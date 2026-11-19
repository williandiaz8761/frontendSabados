package edu.itm.frontendSabados.Dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class EstudianteDto {
    Integer idEstudiante;
    String nombres;
    String apellidos;
    String email;
    String direccion;
    String celular;
    String identificacion;
    String programa;
    LocalDate fechaIngreso;
    LocalDate fechaNacimiento;

    private List<CursoEstudianteDto> estudianteCursos;

}
