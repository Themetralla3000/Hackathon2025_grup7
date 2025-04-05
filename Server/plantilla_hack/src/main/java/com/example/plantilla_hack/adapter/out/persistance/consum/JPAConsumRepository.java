package com.example.plantilla_hack.adapter.out.persistance.consum;

import com.example.plantilla_hack.application.port.out.persistance.ConsumRepository;
import com.example.plantilla_hack.model.Consum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JPAConsumRepository implements ConsumRepository {

    private final JPAConsumDataSpringRepository consumJpaRepository;

    public JPAConsumRepository(JPAConsumDataSpringRepository consumJpaRepository) {
        this.consumJpaRepository = consumJpaRepository;
    }

    @Override
    public List<Consum> getAllDays(String email) {
        List<ConsumJPAEntity> consumJPAEntities = consumJpaRepository.findByUserEmail(email);
        return consumJPAEntities.stream()
                .map(consumJPAEntity -> new Consum(
                        consumJPAEntity.getDate(),
                        consumJPAEntity.getDucha(),
                        consumJPAEntity.getGrifo(),
                        consumJPAEntity.getLavadora(),
                        consumJPAEntity.getCisterna(),
                        consumJPAEntity.getLavaplatos(),
                        consumJPAEntity.getTotal(),
                        email))
                .collect(Collectors.toList());
    }

    @Override
    public Consum getConsumSpecificDay(Date date, String email) {
        return ConsumMapper.toModel(consumJpaRepository.findByUserEmailAndDate(email, date));

    }

    @Override
    public List<Consum> getLastMonth(String email) {

        List<Consum> consumList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        for (int i = 1; i < 31; i++) {
            Consum consum = getConsumSpecificDay(currentDate, email);
            if (consum != null) {
                consumList.add(consum);
            }
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            currentDate = calendar.getTime();
        }

        return consumList;

    }

    @Override
    public List<Consum> getLastWeek(String email) {


        List<Consum> consumList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        for (int i = 1; i <= 7; i++) {
            Consum consum = getConsumSpecificDay(currentDate, email);
            if (consum != null) {
                consumList.add(consum);
            }
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            currentDate = calendar.getTime();
        }

        return consumList;

    }

    @Override
    public Consum getLastDay(String email) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        return getConsumSpecificDay(currentDate, email);
    }
}