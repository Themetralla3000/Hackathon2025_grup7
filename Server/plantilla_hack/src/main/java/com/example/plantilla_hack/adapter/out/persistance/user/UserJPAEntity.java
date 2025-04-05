package com.example.plantilla_hack.adapter.out.persistance.user;

import com.example.plantilla_hack.adapter.out.persistance.consum.ConsumJPAEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
public class UserJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Getter
    @Setter
    private long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String fullName;

    @Setter
    @Getter
    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Setter
    @Getter
    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Setter
    @Getter
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Setter
    @Getter
    @Column(name = "updated_at")
    private Date updatedAt;

    @Setter
    @Getter
    @Column(name = "racha")
    private int racha;

    @Setter
    @Getter
    @Column(name = "poblacio")
    private String poblacio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ConsumJPAEntity> consums;




// Getters and setters
}