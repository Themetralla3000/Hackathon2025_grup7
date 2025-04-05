package com.example.plantilla_hack.application.service.consum;

import com.example.plantilla_hack.application.port.in.consum.*;
import com.example.plantilla_hack.application.port.out.persistance.ConsumRepository;
import com.example.plantilla_hack.model.Consum;

import java.util.Date;
import java.util.List;

public class ConsumeDaysService implements GetAllDaysUseCase, GetConsumSpecificDayUseCase, GetLastWeekUseCase, GetLastMonthUseCase, GetYesterdayUseCase {

    private final ConsumRepository consumRepository;


    public ConsumeDaysService(ConsumRepository consumRepository) {
        this.consumRepository = consumRepository;
    }

    @Override
    public List<Consum> getAllDays(String email) {
        return consumRepository.getAllDays(email);
    }

    @Override
    public Consum getConsumSpecificDay(Date date,String email) {
        return consumRepository.getConsumSpecificDay(date,email);
    }

    @Override
    public List<Consum> getLastWeek(String email) {
        return consumRepository.getLastWeek(email);
    }

    @Override
    public List<Consum> getLastMonth(String email) {
        return consumRepository.getLastMonth(email);
    }

    @Override
    public Consum getYesterday(String email) {
        return consumRepository.getLastDay(email);
    }
}
