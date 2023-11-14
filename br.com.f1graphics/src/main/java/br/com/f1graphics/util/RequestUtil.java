package br.com.f1graphics.util;

import br.com.f1graphics.configuration.F1WebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestUtil {

    private final F1WebClient f1WebClient;

    public <T> T get(String endpoint, Class<T> entity) {
        return f1WebClient.getLiferayWebClient().get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(entity)
                .block();
    }


}
