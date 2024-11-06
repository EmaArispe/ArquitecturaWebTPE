package org.example.microservscooter.repository;

import org.example.microservscooter.dto.ScooterDTO;
import org.example.microservscooter.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScooterRepository extends JpaRepository<Scooter,Long> {

    @Query("SELECT org.example.microservscooter.dto.ScooterDTO (s.id_scooter, s.latitude, s.longitude, s.kilometers, s.usageTime, s.maintenance )"+
            " FROM Scooter s "+
            " WHERE s.id_scooter = :id")
    ScooterDTO getScooterByMaintenance(@Param("id") Long id);
}
