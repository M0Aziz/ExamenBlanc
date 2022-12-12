package com.example.mohamedazizchouchi_.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String designation;
    private String adresse;
    private Integer capacite;

    @OneToMany(mappedBy = "parking")
    private List<Zone> zones;
}
