package com.project.ProjectSpringBoot.service;

import java.util.List;

import com.project.ProjectSpringBoot.domain.Project; // se importa el paquete para traer los metodos que vamos a implementar 

public interface ProjectServiceIMP {

    // permite la declaracion List traer todos los datos de la base de datos
    public List<Project> listProject();

    // utilizaos el metodo save para guardar los datos en project
    public void Save(Project project);

    // utilizaos el metodo delete para eliminar los datos en project
    public void Delete(Project project);

    // utilizaos el metodo Localitation para buscar los datos en project
    public Project Localitation(Project project);

}
