package com.example.client.client;

import com.example.client.model.VoitureResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-voiture")
public interface VoitureClient {
    @GetMapping("/api/voitures/client/{clientId}")
    VoitureResponse getVoiture(@PathVariable("clientId") Long clientId);
}