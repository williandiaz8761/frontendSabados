package edu.itm.frontendSabados.vistas;

import edu.itm.frontendSabados.Dtos.EstudianteDto;
import edu.itm.frontendSabados.webservicesclients.EstudianteApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EstudianteViewController {
    @Autowired
    EstudianteApiClient estudianteClient;

    /**
     * conversión de fechas.
     * Registra un editor de propiedades para java.util.Date,
     * indicando el formato esperado ("yyyy-MM-dd") que envían los inputs HTML type="date".
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Formato que envía el input HTML type="date"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // No permitir valores nulos para los campos de fecha
        boolean allowEmpty = false;

        // Registra el editor de propiedades para todos los campos de tipo Date
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, allowEmpty));
    }

    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model) {
        try {
            List<EstudianteDto> listaEstudiantes = obtenerEstudiantesDeApiRest();
            model.addAttribute("estudiantes", listaEstudiantes);

        } catch (Exception e) {
            model.addAttribute("error", "No se pudieron cargar los estudiantes desde el servicio REST.");
        }

        return "estudiantes"; // Renderiza estudiantes.html
    }

    @GetMapping("/registroestudiante")
    public String mostrarFormulario(Model model){
        model.addAttribute("estudianteDto", new EstudianteDto());
        return "registroestudiante";
    }

    @PostMapping("/registroestudiante")
    public String guardarEstudiante(@ModelAttribute("estudianteDto") EstudianteDto estudianteDto, Model model){
        /*
          @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("edad") int edad,
        * */

        System.out.println("entrando al guardado del estudiante");
        System.out.println("nombres "+estudianteDto.getNombres());
        System.out.println("Apellidos "+estudianteDto.getApellidos());

        model.addAttribute("estudianteRegistrado", estudianteDto);

        return "resultado";
    }

    private List<EstudianteDto> obtenerEstudiantesDeApiRest() {
        return estudianteClient.getEstudiantes();
    }
}
