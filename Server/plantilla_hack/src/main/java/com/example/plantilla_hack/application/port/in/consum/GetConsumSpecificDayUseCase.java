package com.example.plantilla_hack.application.port.in.consum;

import com.example.plantilla_hack.model.Consum;

import java.util.Date;

public interface GetConsumSpecificDayUseCase {

    Consum getConsumSpecificDay(Date date,String email);
}
