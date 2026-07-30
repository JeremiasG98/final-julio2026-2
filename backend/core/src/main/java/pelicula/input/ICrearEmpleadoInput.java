package pelicula.input;

import pelicula.modelo.Empleado;
import pelicula.modelo.Puesto;

import java.time.LocalDateTime;

public interface ICrearEmpleadoInput {
    Empleado ejecutar(String nombre, String legajo, LocalDateTime fechaIngreso, Puesto puesto, double salario);
}
