package com.example.mohamedazizchouchi_.Repository;

import com.example.mohamedazizchouchi_.Entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingRepository extends JpaRepository<Parking,Integer> {
    @Query("SELECT COUNT(p.id) as nb from Personnel p , Parking par , Zone z where z.personnel.id = p.id AND par.adresse =:adresse")
    Integer nombreGardeJour(@Param("adresse") String adresse);
}
