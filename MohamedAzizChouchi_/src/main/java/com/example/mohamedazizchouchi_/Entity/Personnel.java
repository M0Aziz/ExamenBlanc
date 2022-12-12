package com.example.mohamedazizchouchi_.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date dateDeRecrutement;
    private String login;
    private String password;
@Enumerated(EnumType.STRING)
    private Poste poste;



    @OneToOne(mappedBy = "personnel")
    private Zone zone;
}
