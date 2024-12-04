package com.project.ProjectSpringBoot.domain;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data // genera los metodos setters y getters

@Entity // mapea los datos en la base de datos

@Table(name = "Project") // hace referencia al nombre de la base de datos

public class Project implements Serializable {

    // se crea con el fin de evitar problemas de compatibilidad
    private static final long serialVersionUID = 1L;

    @Id // indica la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // se genera automaticamente los valores de la clave primaria

    // datos de la base de datos
    private long Idhomework;

    @NotEmpty // Se utiliza para la gestion de los campos o errores
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private String ready;

    private LocalDate date;

}
