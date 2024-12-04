package com.project.ProjectSpringBoot.service;

import java.util.List; // para gestionar las listas del proyecto

import org.springframework.beans.factory.annotation.Autowired; // se importa para el manejo de transaciones e inyecciones de dependencias 

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.project.ProjectSpringBoot.domain.Project; // entidad que reprenseta el proyecto

import com.project.ProjectSpringBoot.mx.ProjectRepository; // proporciona los metodos CRUD

@Service // marca la calse ProjectService como un servicio lo que facilita la inyecion de
         // dependencias

public class ProjectService implements ProjectServiceIMP { // se implementa ProjectServiceIMP para asegurarse de traer
                                                           // los metodos

    @Autowired // inyecta o trae los metodos de ProjectRepository
    private ProjectRepository projectRepository;

    @Override
    @Transactional(readOnly = true) // Configura el método como transaccional y de solo lectura, para mejorar el
                                    // rendimiento y consultas
    public List<Project> listProject() {
        return (List<Project>) projectRepository.findAll(); // recupera los proyectos y los devuelve

    }

    @Override
    @Transactional // garantiza que la operecion se ejecute
    public void Save(Project project) {
        projectRepository.save(project); // guarda o actualiza segun el id
    }

    @Override
    @Transactional // garantiza que la operecion se ejecute
    public void Delete(Project project) {
        projectRepository.delete(project); // elimina el poryecto segun el id
    }

    @Override
    @Transactional(readOnly = true) // Configura el método como transaccional y de solo lectura, para mejorar el
                                    // rendimiento y consultas
    public Project Localitation(Project project) {
        return projectRepository.findById(project.getIdhomework()).orElse(null); // return
                                                                                 // projectRepository.findById(project.getIdhomework())
                                                                                 // busca el poryecto en la base de
                                                                                 // datos por su id y orElse(null) es
                                                                                 // por si no encuentra e proyecto
                                                                                 // devuelva null
    }

}
