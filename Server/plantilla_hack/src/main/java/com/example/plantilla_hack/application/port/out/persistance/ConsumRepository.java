package com.example.plantilla_hack.application.port.out.persistance;

import com.example.plantilla_hack.model.Consum;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsumRepository {

    List<Consum> getAllDays(String email);
    Consum getConsumSpecificDay(Date date,String email);
    List<Consum> getLastMonth(String email);
    List<Consum> getLastWeek(String email);
    Consum getLastDay(String email);
}
