package pelicula.usecase;

import pelicula.exceptions.EmpleadoInexistenteException;
import pelicula.input.IBuscarEmpleadoPorLegajoInput;
import pelicula.modelo.Empleado;
import pelicula.output.IEmpleadoOutPut;

import java.util.Optional;

public class BuscarEmpleadoPorLegajoUseCase implements IBuscarEmpleadoPorLegajoInput {
    private IEmpleadoOutPut outPut;
    public BuscarEmpleadoPorLegajoUseCase(IEmpleadoOutPut outPut) {
        this.outPut = outPut;
    }

    @Override
    public Optional<Empleado> ejecutar(String legajo) {
        Optional<Empleado> empleado = outPut.buscarEmpleadoPorLegajo(legajo);
        if(empleado.isEmpty()){
            throw new EmpleadoInexistenteException("El empleado no existe.");
        }
        return empleado;
    }
}
