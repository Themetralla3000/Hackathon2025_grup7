package com.example.plantilla_hack.adapter.out.persistance.consum;

import com.example.plantilla_hack.adapter.out.persistance.user.UserJPAEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name="consum")
public class ConsumJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long idConsum;

    @Column(name="ConsumDate")
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private int ducha;
    @Getter
    @Setter
    private int grifo;
    @Getter
    @Setter
    private int lavadora;
    @Getter
    @Setter
    private int cisterna;
    @Getter
    @Setter
    private int lavaplatos;
    @Getter
    @Setter
    private int total;

    @Getter
    @Setter
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJPAEntity user;

    public ConsumJPAEntity() {
    }

    public ConsumJPAEntity(Date date, int ducha, int grifo, int lavadora, int cisterna, int lavaplatos, int total, String email) {
        this.date = date;
        this.ducha = ducha;
        this.grifo = grifo;
        this.lavadora = lavadora;
        this.cisterna = cisterna;
        this.lavaplatos = lavaplatos;
        this.total = total;
        this.email = email;
    }
}
