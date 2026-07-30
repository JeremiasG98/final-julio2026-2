package usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pelicula.exceptions.EmpleadoInexistenteException;
import pelicula.modelo.Empleado;
import pelicula.modelo.Puesto;
import pelicula.output.IEmpleadoOutPut;
import pelicula.usecase.BuscarEmpleadoPorLegajoUseCase;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuscarEmpleadoPorLegajoUseCaseUnitTest {
    private IEmpleadoOutPut outPut;
    private BuscarEmpleadoPorLegajoUseCase useCase;
    @BeforeEach
    void setUp(){
        outPut = mock(IEmpleadoOutPut.class);
        useCase = new BuscarEmpleadoPorLegajoUseCase(outPut);
    }
    @Test
    void shouldObtenerEmpleadoSearchedByLegajo(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;

        Empleado empleado = Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario);
        when(outPut.buscarEmpleadoPorLegajo(legajo)).thenReturn(Optional.of(empleado));

        Optional<Empleado> resultado = useCase.ejecutar(legajo);

        assertNotNull(resultado);
        assertEquals(empleado.getNombre(),resultado.get().getNombre());
        assertEquals(empleado.getPuesto(),resultado.get().getPuesto());
        verify(outPut).buscarEmpleadoPorLegajo(legajo);

    }
    @Test
    void shouldThrowEmpleadoInexistenteException(){
        String legajo = "ABC1234";
        when(outPut.buscarEmpleadoPorLegajo(legajo)).thenReturn(Optional.empty());

        assertThrows(EmpleadoInexistenteException.class, () -> useCase.ejecutar(legajo));
        verify(outPut).buscarEmpleadoPorLegajo(legajo);
    }
}
