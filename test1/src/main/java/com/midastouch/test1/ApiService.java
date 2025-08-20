package com.midastouch.test1;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiService {

    private final WebClient webClient = WebClient.builder()
        .baseUrl("https://api.polygon.io")
        // Replace xxxx with your actual API key
        .defaultHeader("Authorization", "Bearer xxxx")
        .build();

    public String callApi() {
        return webClient.get()
            .uri("v1/open-close/SPY/2025-08-19?adjusted=true")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
