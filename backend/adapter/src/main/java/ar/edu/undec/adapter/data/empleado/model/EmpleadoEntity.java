package ar.edu.undec.adapter.data.empleado.model;

import jakarta.persistence.*;
import lombok.Getter;
import pelicula.modelo.Puesto;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name="empleados")
public class EmpleadoEntity {
    @Id
    private UUID id;
    private String nombre;
    private String legajo;
    private LocalDateTime fechaIngreso;
    @Enumerated(EnumType.STRING)
    private Puesto puesto;
    private double salario;

    public EmpleadoEntity(){}

    public EmpleadoEntity(UUID id, String nombre, String legajo, String fechaIngreso, Puesto puesto, double salario){
        this.id = id;
        this.nombre = nombre;
        this.legajo = legajo;
        this.fechaIngreso = LocalDateTime.parse(fechaIngreso);
        this.puesto = puesto;
        this.salario = salario;
    }
}
