package pelicula.usecase;

import pelicula.exceptions.EmpleadoDuplicadoException;
import pelicula.input.ICrearEmpleadoInput;
import pelicula.modelo.Empleado;
import pelicula.modelo.Puesto;
import pelicula.output.IEmpleadoOutPut;

import java.time.LocalDateTime;
import java.util.UUID;

public class CrearEmpleadoUseCase implements ICrearEmpleadoInput {
    private IEmpleadoOutPut outPut;

    public CrearEmpleadoUseCase(IEmpleadoOutPut outPut) {
        this.outPut = outPut;
    }

    @Override
    public Empleado ejecutar(String nombre, String legajo, LocalDateTime fechaIngreso, Puesto puesto, double salario) {
        if(outPut.buscarEmpleadoPorLegajo(legajo).isPresent()){
            throw new EmpleadoDuplicadoException("El empleado ya existe.");
        }
        UUID id = UUID.randomUUID();
        Empleado empleado = Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario);
        return empleado;
    }
}
