package cat.tecnocampus.apollofy.configuration.restClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfiguration {

    @Bean
    public WebClient createWebClient() {
        return WebClient.create("http://localhost/api");
    }
}
