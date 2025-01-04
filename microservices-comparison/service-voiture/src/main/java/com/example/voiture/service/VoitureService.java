package com.example.voiture.service;

import com.example.voiture.model.Voiture;
import com.example.voiture.repository.VoitureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoitureService {
    private final VoitureRepository voitureRepository;

    public Voiture getVoitureByClientId(Long clientId) {
        return voitureRepository.findByClientId(clientId);
    }
}