package com.example.mohamedazizchouchi_.Controllers;

import com.example.mohamedazizchouchi_.Entity.Parking;
import com.example.mohamedazizchouchi_.Entity.Personnel;
import com.example.mohamedazizchouchi_.Entity.Zone;
import com.example.mohamedazizchouchi_.Repository.ParkingRepository;
import com.example.mohamedazizchouchi_.Repository.PersonnelRepository;
import com.example.mohamedazizchouchi_.Repository.ZoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("rest")
public class ExamRestController {

@Autowired
    PersonnelRepository personnelRepository;
@Autowired
    ZoneRepository zoneRepository;
@Autowired
    ParkingRepository parkingRepository;


    @PostMapping("/add-personnel")
    public Personnel ajouterPersonnel (@RequestBody Personnel personnel) {
        return personnelRepository.save(personnel);
    }


    @PostMapping("/add-parkingzone")
   public void ajouterParkingetZones (@RequestBody Parking parking) {

        parkingRepository.save(parking);
        System.out.println(parking.getZones());
        for (Zone z :parking.getZones()){

            z.setParking(parking);
        }
    }

    @PostMapping("/add-personnelzone/{idzone}/{idgarde}")
    void affecterPersonnelZone (@PathVariable Integer idzone,@PathVariable Integer idgarde) {

       Personnel p = personnelRepository.findById(idgarde).get();
        Zone zone = zoneRepository.findById(idzone).orElse(null);
   Personnel personnel = null;
        System.out.println(zone);
   //personnel.setZone(zone);
        ArrayList<Personnel> per = new ArrayList<Personnel>();
        per.add(p);
        zone.setPersonnels(per);
    }
    @PostMapping("/get-personnelparking")

    List<Personnel> getAllPersonnelByParking(@RequestBody Parking parking){


      List<Zone> x = parking.getZones();
        System.out.println(x);
return null;

    }

    public List<Personnel> getPersonnalByDate (Date startDate, Date endDate){

        return null;
    }
    @GetMapping("/nbGarde/{adresse}")
    Integer nombreGardeJour(@PathVariable String adresse){

        return parkingRepository.nombreGardeJour(adresse);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void getNbrGardesByZone() {
       int total = 0;
        List<Personnel> personnels = personnelRepository.findAll();
        for (Personnel personnel : personnels) {

       if (personnel.getPoste().equals("GARDE_JOUR")){
           total += 1;


           log.info("Nombre des gardes : " + total + "Zone"+ personnel.getZone() );


       }
            ;
        }
    }
}
