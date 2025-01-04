package com.example.client.controller;

import com.example.client.client.VoitureClient;
import com.example.client.model.VoitureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final RestTemplate restTemplate;
    private final VoitureClient voitureClient;
    private final WebClient.Builder webClientBuilder;

    // Fetch car details using RestTemplate
    @GetMapping("/{id}/voiture-rest")
    public VoitureResponse getVoitureByRestTemplate(@PathVariable Long id) {
        return restTemplate.getForObject(
                "http://service-voiture/api/voitures/client/" + id,
                VoitureResponse.class
        );
    }

    // Fetch car details using Feign Client
    @GetMapping("/{id}/voiture-feign")
    public VoitureResponse getVoitureByFeign(@PathVariable Long id) {
        return voitureClient.getVoiture(id);
    }

    // Fetch car details using WebClient (reactive)
    @GetMapping("/{id}/voiture-webclient")
    public Mono<VoitureResponse> getVoitureByWebClient(@PathVariable Long id) {
        return webClientBuilder.build()
                .get()
                .uri("http://service-voiture/api/voitures/client/" + id)
                .retrieve()
                .bodyToMono(VoitureResponse.class);
    }
}