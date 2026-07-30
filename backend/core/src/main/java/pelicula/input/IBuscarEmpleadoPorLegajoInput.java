package pelicula.input;

import pelicula.modelo.Empleado;

import java.util.Optional;

public interface IBuscarEmpleadoPorLegajoInput {
    Optional<Empleado> ejecutar(String legajo);
}
