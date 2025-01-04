package com.example.voiture.controller;

import com.example.voiture.model.Voiture;
import com.example.voiture.service.VoitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voitures")
@RequiredArgsConstructor
public class VoitureController {
    private final VoitureService voitureService;

    @GetMapping("/client/{clientId}")
    public Voiture getVoitureByClientId(@PathVariable Long clientId) {
        return voitureService.getVoitureByClientId(clientId);
    }
}