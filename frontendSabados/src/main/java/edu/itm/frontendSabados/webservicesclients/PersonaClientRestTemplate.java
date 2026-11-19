package edu.itm.frontendSabados.webservicesclients;

import edu.itm.frontendSabados.Dtos.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonaClientRestTemplate {
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.estudiantes.base-url:http://localhost:9090/appInicial}")
    private String baseUrl;

    public List<PersonaDto> getPersonas() {
        String url = baseUrl + "/personas/listar";
        PersonaDto[] personasArray = restTemplate.getForObject(url, PersonaDto[].class);
        return List.of(personasArray);
    }


}
