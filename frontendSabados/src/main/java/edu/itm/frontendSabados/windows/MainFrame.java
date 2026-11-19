package edu.itm.frontendSabados.windows;

import edu.itm.frontendSabados.Dtos.CursoDto;
import edu.itm.frontendSabados.Dtos.CursoEstudianteDto;
import edu.itm.frontendSabados.Dtos.EstudianteDto;
import edu.itm.frontendSabados.Dtos.PersonaDto;
import edu.itm.frontendSabados.webservicesclients.CursoApiClient;
import edu.itm.frontendSabados.webservicesclients.EstudianteApiClient;
import edu.itm.frontendSabados.webservicesclients.PersonaClientRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class MainFrame extends JFrame {

    @Autowired
    PersonaClientRestTemplate presonaClient;

    @Autowired
    EstudianteApiClient estudianteClient;

    @Autowired
    CursoApiClient cursoClient;

    JTextArea textArea = new JTextArea(20, 50);

    public MainFrame(){
        setSize(500,400);
    }

    public void iniciar(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Ejemplo consumo Back end");
        setResizable(false);
        setLocation(300,200);
        setLayout(new BorderLayout(50,50));
        JButton boton = new JButton("Probar llamado a clients");

        add(textArea,BorderLayout.NORTH);
        add(boton,BorderLayout.SOUTH);
        boton.addActionListener(invocar());
    }

    private ActionListener invocar(){
        return (e) -> {
            java.util.List<PersonaDto> personas = presonaClient.getPersonas();

            for(PersonaDto persona : personas){
                textArea.append(persona.getCedula() + " " + persona.getNombres() + " " + persona.getApellidos() + "\n");
            }
            System.out.println(personas);

            java.util.List<EstudianteDto> estudiantes = estudianteClient.getEstudiantes();

            for(EstudianteDto estudiante : estudiantes){
                textArea.append(estudiante.getNombres() + " " + estudiante.getApellidos() + "\n");
                for(CursoEstudianteDto curso : estudiante.getEstudianteCursos()){
                    textArea.append(curso.getCurso().getNombre() + " " + curso.getCurso().getCodigo() + "\n");

                }
            }

            System.out.println(estudiantes);

            java.util.List<CursoDto> cursos = cursoClient.getCursos();

            for(CursoDto curso : cursos){
                textArea.append(curso.getNombre() + " " + curso.getCodigo() + "\n");
            }

            System.out.println(cursos);
        };
    }


}
