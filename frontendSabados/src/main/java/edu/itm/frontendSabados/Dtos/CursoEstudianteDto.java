package edu.itm.frontendSabados.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CursoEstudianteDto {
    private Integer idEstudianteCurso;
    private LocalDateTime fechaMatricula;
    private String semestre;
    private Integer isEstudianteCurso;
    private CursoDto curso;
    private EstudianteDto estudiante;
}
