package com.midastouch.test1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiService {

    private final String key;
    private final WebClient webClient;

    // The key is now referenced by its new name, "API_KEY"
    public ApiService(@Value("${API_KEY}") String key) {
        this.key = key;

        this.webClient = WebClient.builder()
            .baseUrl("https://api.polygon.io")
            .build();
    }

    public String callApi() {
        return webClient.get()
            // Here, we add the 'apiKey' as a query parameter to the URL
            .uri(uriBuilder -> uriBuilder
                .path("/v1/open-close/SPY/2025-08-19")
                .queryParam("adjusted", "true")
                .queryParam("apiKey", this.key)
                .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
