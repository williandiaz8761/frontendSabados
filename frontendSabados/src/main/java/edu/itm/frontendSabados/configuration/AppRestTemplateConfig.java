package edu.itm.frontendSabados.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppRestTemplateConfig {
    /*
         define una instancia de un rest template que puede ser inyectado en cualquier
         parte de nuestro proyecto.
     */

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
