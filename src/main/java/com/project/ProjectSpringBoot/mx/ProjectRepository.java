package com.project.ProjectSpringBoot.mx;

import org.springframework.data.repository.CrudRepository;

import com.project.ProjectSpringBoot.domain.Project;

// proporciona los métodos básicos para realizar operaciones CRUD con la importación CrudRepository

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
