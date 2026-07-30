package usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pelicula.modelo.Empleado;
import pelicula.modelo.Puesto;
import pelicula.output.IEmpleadoOutPut;
import pelicula.usecase.ObtenerEmpleadosUseCase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ObtenerEmpleadosUseCaseUnitTest {
    private IEmpleadoOutPut outPut;
    private ObtenerEmpleadosUseCase useCase;
    @BeforeEach
    void setUp (){
        outPut = mock(IEmpleadoOutPut.class);
        useCase = new ObtenerEmpleadosUseCase(outPut);
    }
    @Test
    void shouldObtenerAllEmpleadosInAList(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;
        Empleado empleado = Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario);

        UUID id2 = UUID.randomUUID();
        String nombre2 = "Juan Lopez";
        String legajo2 = "ABC1235";
        LocalDateTime fechaIngreso2 = LocalDateTime.now();
        Puesto puesto2 = Puesto.ANALISTA;
        double salario2 = 10000000;
        Empleado empleado2 = Empleado.instanciar(id2,nombre2,legajo2,fechaIngreso2,puesto2,salario2);

        when(outPut.obtenerTodos()).thenReturn(List.of(empleado,empleado2));
        List<Empleado> resultado = useCase.ejecutar();
        assertEquals(2,resultado.size());
        assertEquals(empleado.getNombre(),resultado.get(0).getNombre());
        assertEquals(empleado2.getNombre(),resultado.get(1).getNombre());
        verify(outPut).obtenerTodos();
    }
    @Test
    void shouldReturnAnEmptyList(){
        when(outPut.obtenerTodos()).thenReturn(List.of());
        List<Empleado> resultado = useCase.ejecutar();

        assertTrue(resultado.isEmpty());
        assertEquals(0,resultado.size());
        verify(outPut).obtenerTodos();
    }
}
