package com.example.plantilla_hack.adapter.out.persistance.consum;

import com.example.plantilla_hack.model.Consum;

public class ConsumMapper {
    public static ConsumJPAEntity toEntity(Consum consum) {

        ConsumJPAEntity consumJPAEntity = new ConsumJPAEntity();
        consumJPAEntity.setDate(consum.getDate());
        consumJPAEntity.setDucha(consum.getDucha());
        consumJPAEntity.setGrifo(consum.getGrifo());
        consumJPAEntity.setLavadora(consum.getLavadora());
        consumJPAEntity.setCisterna(consum.getCisterna());
        consumJPAEntity.setLavaplatos(consum.getLavaplatos());
        consumJPAEntity.setTotal(consum.getTotal());
        consumJPAEntity.setEmail(consum.getEmail());

        return consumJPAEntity;

    }

    public static Consum toModel(ConsumJPAEntity consumJPAEntity) {

        return new Consum(
                consumJPAEntity.getDate(),
                consumJPAEntity.getDucha(),
                consumJPAEntity.getGrifo(),
                consumJPAEntity.getLavadora(),
                consumJPAEntity.getCisterna(),
                consumJPAEntity.getLavaplatos(),
                consumJPAEntity.getEmail()
        );
    }
}