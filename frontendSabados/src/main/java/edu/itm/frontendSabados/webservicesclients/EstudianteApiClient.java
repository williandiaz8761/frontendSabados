package edu.itm.frontendSabados.webservicesclients;

import edu.itm.frontendSabados.Dtos.EstudianteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "estudiante-api-client", url = "${api.estudiantes.base-url:http://localhost:9090/appInicial/estudiantes}")
public interface EstudianteApiClient {

    @GetMapping("/listar")
    List<EstudianteDto> getEstudiantes();
}
