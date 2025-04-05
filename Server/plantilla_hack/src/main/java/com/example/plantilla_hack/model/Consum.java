package com.example.plantilla_hack.model;

import com.example.plantilla_hack.adapter.out.persistance.user.UserJPAEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Consum {

    @Setter
    @Getter
    private Date date;
    @Setter
    @Getter
    private int ducha;
    @Setter
    @Getter
    private int grifo;
    @Setter
    @Getter
    private int lavadora;
    @Setter
    @Getter
    private int cisterna;
    @Setter
    @Getter
    private int lavaplatos;
    @Setter
    @Getter
    private int total;
    @Setter
    @Getter
    private String email;

    public Consum(Date date, int ducha, int grifo, int lavadora, int cisterna, int lavaplatos,String email) {
        this.date = date;
        this.ducha = ducha;
        this.grifo = grifo;
        this.lavadora = lavadora;
        this.cisterna = cisterna;
        this.lavaplatos = lavaplatos;
        this.total = calculateTotal();
        this.email=email;
    }
    public Consum(Date date, int ducha, int grifo, int lavadora, int cisterna, int lavaplatos, int total, String email) {
        this.date = date;
        this.ducha = ducha;
        this.grifo = grifo;
        this.lavadora = lavadora;
        this.cisterna = cisterna;
        this.lavaplatos = lavaplatos;
        this.total = total;
        this.email=email;
    }


    private int calculateTotal() {
        return ducha + grifo + lavadora + cisterna + lavaplatos;
    }


}
