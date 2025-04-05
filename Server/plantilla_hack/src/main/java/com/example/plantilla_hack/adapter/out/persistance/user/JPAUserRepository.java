package com.example.plantilla_hack.adapter.out.persistance.user;


import com.example.plantilla_hack.application.port.out.persistance.UserRepository;
import com.example.plantilla_hack.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JPAUserRepository implements UserRepository {

    private final JPAUserSpringDataRepository userJpaRepository;

    public JPAUserRepository(JPAUserSpringDataRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    @Transactional
    public void save(User user) {
        userJpaRepository.save(UserMapper.toEntity(user));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserJPAEntity> userJPAEntity = userJpaRepository.findByEmail(email);
        return userJPAEntity.map(UserMapper::toModel);
    }

    @Override
    public List<User> findAll() {
        return ((List<UserJPAEntity>) userJpaRepository.findAll()).stream().map(UserMapper::toModel).collect(Collectors.toList());    }

    @Override
    public List<User> getAllRanking() {
        return findAll();
    }

    @Override
    @Transactional
    public void reiniciarRacha(String email) {
        Optional<UserJPAEntity> userJPAEntity = userJpaRepository.findByEmail(email);
        if (userJPAEntity.isPresent()) {
            UserJPAEntity user = userJPAEntity.get();
            user.setRacha(0);
            userJpaRepository.save(user);
        }
    }

    @Override
    public int getRacha(String email) {
        Optional<UserJPAEntity> userJPAEntity = userJpaRepository.findByEmail(email);
        return userJPAEntity.map(UserJPAEntity::getRacha).orElse(-1);
    }

    @Override
    @Transactional
    public void aumentarRacha(String email) {

        Optional<UserJPAEntity> userJPAEntity = userJpaRepository.findByEmail(email);
        if (userJPAEntity.isPresent()) {
            UserJPAEntity user = userJPAEntity.get();
            user.setRacha(user.getRacha() + 1);
            userJpaRepository.save(user);
        }
    }



    @Override
    public List<User> getRankingSpecificPoblacio(String poblacio) {

        List<UserJPAEntity> users = userJpaRepository.getRankingPoblacio(poblacio);
        return users.stream()
                .filter(user -> user.getPoblacio().equals(poblacio))
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }
}
