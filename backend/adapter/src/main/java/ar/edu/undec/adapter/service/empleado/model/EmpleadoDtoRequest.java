package ar.edu.undec.adapter.service.empleado.model;

public record EmpleadoDtoRequest(String nombre, String legajo, String fechaIngreso, String puesto, double salario) {
}
