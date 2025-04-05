package com.example.plantilla_hack.application.port.in.consum;

import com.example.plantilla_hack.model.Consum;

import java.util.List;

public interface GetLastWeekUseCase {

    List<Consum> getLastWeek(String email);

}
