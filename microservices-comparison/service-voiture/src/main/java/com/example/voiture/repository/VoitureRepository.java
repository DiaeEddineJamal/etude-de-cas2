package com.example.voiture.repository;

import com.example.voiture.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    Voiture findByClientId(Long clientId);
}