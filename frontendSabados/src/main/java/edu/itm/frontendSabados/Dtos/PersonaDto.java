package edu.itm.frontendSabados.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaDto {
    Integer idPersona;
    String nombres;
    String apellidos;
    String email;
    String celular;
    String direccion;
    String cedula;
    String telefono;
    Date fechaNacimiento;
}
