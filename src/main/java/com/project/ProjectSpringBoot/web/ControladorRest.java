package com.project.ProjectSpringBoot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.ProjectSpringBoot.domain.Project;
import com.project.ProjectSpringBoot.service.ProjectService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller // para gestionar solicitudes web

@Slf4j // Añade un registro de mensajes (logger) usando la biblioteca Lombok

public class ControladorRest {

    // El Autowired permite la inyección de dependencias automáticas de
    // ProjectService
    @Autowired
    private ProjectService projectService;

    @GetMapping("/") // maneja la solicitudes get en la raiz (/)

    public String seeProject(Model model) {
        List<Project> project = projectService.listProject(); // Llama al servicio listProject() para obtener una lista
                                                              // de proyectos desde la base de datos
        model.addAttribute("project", project);
        return "indice"; // agrega la lista al indice.html
    }

    @GetMapping("/add") // maneja las solicitudes GET para mostrar el formulario de creacion
    public String add(Project project) {
        // redirige a la pagina change.Html
        return "change";
    }

    @PostMapping("/Save") // maneja la solicitud POST para guardar

    // @Valid Project project: Valida automáticamente el objeto usando las
    // anotaciones de validación en la clase y Errors errors: Captura cualquier
    // error de validación
    public String save(@Valid Project project, Errors errors) {
        // si hay errores redirige a la pagina change.html
        if (errors.hasErrors()) {
            return "change";
        }
        // Si no hay errores guarda el poryecto en Save y redirige a la pagina principal
        projectService.Save(project);
        return "redirect:/";
    }

    @GetMapping("/change/{Idhomework}") // Maneja las solicitudes GET para cargar los formularios existentes por medio
                                        // de Idhomework
    public String change(Project project, Model model) {
        // busca el poryecto con el metodo Localitation por su id
        project = projectService.Localitation(project);
        model.addAttribute("project", project);
        // Redirige a la pagina change.html
        return "change";
    }

    @GetMapping("/Delete/{Idhomework}") // Maneja las solicitudes GET para eleminar por medio del id
    public String delete(Project project) {
        // elimina el formuario por el metodo Delete por su id
        projectService.Delete(project);
        // redirige a la pagina principal
        return "redirect:/";
    }
}
