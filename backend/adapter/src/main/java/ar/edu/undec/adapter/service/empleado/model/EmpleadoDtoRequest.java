package ar.edu.undec.adapter.service.empleado.model;

import pelicula.modelo.Puesto;

import java.time.LocalDateTime;

public record EmpleadoDtoRequest(String nombre, String legajo, LocalDateTime fechaIngreso, Puesto puesto, double salario) {
}
