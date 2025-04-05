package com.example.plantilla_hack.adapter.out.persistance.consum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JPAConsumDataSpringRepository extends JpaRepository<ConsumJPAEntity, Long> {

    List<ConsumJPAEntity> findByUserEmail(String email);

    ConsumJPAEntity findByUserEmailAndDate(String email, Date date);



}