package pelicula.usecase;

import pelicula.input.IObtenerEmpleadosInput;
import pelicula.modelo.Empleado;
import pelicula.output.IEmpleadoOutPut;

import java.util.List;

public class ObtenerEmpleadosUseCase implements IObtenerEmpleadosInput {
    private IEmpleadoOutPut outPut;

    public ObtenerEmpleadosUseCase(IEmpleadoOutPut outPut) {
        this.outPut = outPut;
    }

    @Override
    public List<Empleado> ejecutar() {
        return outPut.obtenerTodos();
    }
}
