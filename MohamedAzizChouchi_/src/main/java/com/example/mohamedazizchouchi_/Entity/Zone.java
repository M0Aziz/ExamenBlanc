package com.example.mohamedazizchouchi_.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  private String ref;
  private float dimension;

    @OneToMany
    @JsonIgnore
    private List<Personnel> personnels;

    @ManyToOne
    @JsonIgnore
    private Parking parking;

    @OneToOne
    private Personnel personnel;
}
