package com.demodj.demo_examen.Controllers;

import com.demodj.demo_examen.models.Estudiantes;
import com.demodj.demo_examen.Services.EstudiantesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesControllers {

    private final EstudiantesServices estudiantesService;

    @Autowired
    public EstudiantesControllers(EstudiantesServices estudiantesService) {
        this.estudiantesService = estudiantesService;
    }

    // Listar todos los estudiantes
    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudiantesService.findAll());
        return "estudiantes/lista"; // Redirige a una vista llamada "lista"
    }

    // Formulario para crear un nuevo estudiante
    @GetMapping("/nuevo")
    public String nuevoEstudianteForm(Model model) {
        model.addAttribute("estudiante", new Estudiantes());
        return "estudiantes/form"; // Redirige a una vista llamada "form" (formulario)
    }

    // Guardar un nuevo estudiante
    @PostMapping
    public String guardarEstudiante(@ModelAttribute Estudiantes estudiante) {
        estudiantesService.save(estudiante);
        return "redirect:/estudiantes"; // Redirige después de guardar el estudiante
    }

    // Formulario para editar un estudiante existente
    @GetMapping("/editar/{id}")
    public String editarEstudianteForm(@PathVariable Long id, Model model) {
        Optional<Estudiantes> estudiante = estudiantesService.findById(id);
        if (estudiante.isPresent()) {
            model.addAttribute("estudiante", estudiante.get());
            return "estudiantes/form"; // Redirige a la vista del formulario con los datos del estudiante
        } else {
            return "redirect:/estudiantes"; // Si el estudiante no existe, redirige a la lista
        }
    }

    // Actualizar un estudiante existente
    @PostMapping("/editar/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute Estudiantes estudiante) {
        estudiante.setId(id);
        estudiantesService.save(estudiante);
        return "redirect:/estudiantes"; // Redirige a la lista de estudiantes
    }

    // Eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudiantesService.deleteById(id);
        return "redirect:/estudiantes"; // Redirige a la lista después de eliminar el estudiante
    }
}


