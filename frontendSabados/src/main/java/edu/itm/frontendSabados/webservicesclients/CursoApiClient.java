package edu.itm.frontendSabados.webservicesclients;

import edu.itm.frontendSabados.Dtos.CursoDto;
import edu.itm.frontendSabados.Dtos.CursoEstudianteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "curso-api-client", url = "${api.estudiantes.base-url:http://localhost:9090/appInicial/cursos}")
public interface CursoApiClient {
    @GetMapping("/listar")
    List<CursoDto> getCursos();

    @PostMapping("/nuevo")
    CursoDto insertarCurso(@RequestBody CursoDto curso);

    @PostMapping("/actualizar")
    CursoDto actualizarCurso(@RequestBody CursoDto curso);

    @PostMapping("/cursos/matricular")
    CursoEstudianteDto matricularCurso(@RequestParam int idEstudiante, @RequestParam int idCurso);
}
