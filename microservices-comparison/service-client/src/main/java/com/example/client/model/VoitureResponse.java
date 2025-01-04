package com.example.client.model;

import lombok.Data;

@Data
public class VoitureResponse {
    private Long id;
    private String marque;
    private String modele;
    private Long clientId;
}