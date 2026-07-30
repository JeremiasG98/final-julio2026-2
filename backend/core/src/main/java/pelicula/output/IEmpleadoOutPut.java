package pelicula.output;

import pelicula.modelo.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoOutPut {
    Empleado crearEmpleado(Empleado empleado);
    Optional<Empleado> buscarEmpleadoPorLegajo(String legajo);
    List<Empleado> obtenerTodos();
}
