package usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pelicula.exceptions.EmpleadoDuplicadoException;
import pelicula.modelo.Empleado;
import pelicula.modelo.Puesto;
import pelicula.output.IEmpleadoOutPut;
import pelicula.usecase.CrearEmpleadoUseCase;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CrearEmpleadoUseCaseUnitTest {
    private IEmpleadoOutPut outPut;
    private CrearEmpleadoUseCase useCase;
    @BeforeEach
    void setUp(){
        outPut = mock(IEmpleadoOutPut.class);
        useCase = new CrearEmpleadoUseCase(outPut);
    }
    @Test
    void shouldCreateEmpleadoSuccefully(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;

        Empleado empleado = Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario);

        when(outPut.buscarEmpleadoPorLegajo(legajo)).thenReturn(Optional.empty());
        when(outPut.crearEmpleado(any(Empleado.class))).thenReturn(empleado);

        useCase.ejecutar(nombre,legajo,fechaIngreso,puesto,salario);
        ArgumentCaptor<Empleado> captor = ArgumentCaptor.forClass(Empleado.class);

        verify(outPut).crearEmpleado(captor.capture());
        assertNotNull(captor.getValue().getId());
        assertEquals("Juan Perez",captor.getValue().getNombre());
        assertEquals("ABC1234",captor.getValue().getLegajo());
        verify(outPut, times(1)).crearEmpleado(any(Empleado.class));

    }
    @Test
    void shouldThrowEmpleadoDuplicadoException(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;
        Empleado empleado = Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario);
        when(outPut.buscarEmpleadoPorLegajo(legajo)).thenReturn(Optional.of(empleado));

        assertThrows(EmpleadoDuplicadoException.class, () -> useCase.ejecutar(nombre,legajo,fechaIngreso,puesto,salario));
        verify(outPut, never()).crearEmpleado(empleado);
    }
}
