package br.com.f1graphics.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class RequestUtil {

    @Value("${uri.base.liferay.local}")
    private String baseUrl;

    public <T> T get(String endpoint, Class<T> entity) {

        WebClient webClient = WebClient.create(baseUrl);
        return webClient.get()
                .uri(endpoint)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(entity).block();
    }


}
