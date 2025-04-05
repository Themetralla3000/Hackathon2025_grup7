package com.example.plantilla_hack.application.port.out.persistance;

import com.example.plantilla_hack.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {

    void reiniciarRacha(String email);

    int getRacha(String email); //

    void aumentarRacha(String email);

    List<User> getRankingSpecificPoblacio(String poblacio);

    void save(User user);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    List<User> getAllRanking();
}
