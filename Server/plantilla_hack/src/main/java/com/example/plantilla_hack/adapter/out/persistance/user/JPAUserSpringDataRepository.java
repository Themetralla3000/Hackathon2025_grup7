package com.example.plantilla_hack.adapter.out.persistance.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface JPAUserSpringDataRepository extends CrudRepository<UserJPAEntity, Integer> {

    @Query("SELECT u FROM UserJPAEntity u WHERE u.email = :email")
    Optional<UserJPAEntity> findByEmail(@Param("email") String email);


    @Query("SELECT u FROM UserJPAEntity u JOIN u.consums c WHERE u.poblacio = :poblacio AND c = (SELECT c2 FROM ConsumJPAEntity c2 WHERE c2.user = u ORDER BY c2.date DESC LIMIT 1) ORDER BY c.total ASC")
    List<UserJPAEntity> getRankingPoblacio(@Param("poblacio") String poblacio);

    @Query("SELECT u FROM UserJPAEntity u ORDER BY u.racha DESC")
    List<UserJPAEntity> getAllRanking();
}