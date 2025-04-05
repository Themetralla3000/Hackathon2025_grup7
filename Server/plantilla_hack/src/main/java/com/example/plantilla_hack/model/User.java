package com.example.plantilla_hack.model;

import com.example.plantilla_hack.adapter.out.persistance.consum.ConsumJPAEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class User {

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String poblacio;
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private int racha=0;

    private List<ConsumJPAEntity> consums;

    public User() {
    }

    public User(String email, String password, String fullName, String poblacio) {
        this.poblacio = poblacio;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User(String email, String password, String fullName, String poblacio, long id) {
        this.poblacio = poblacio;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.id = id;
    }
}
