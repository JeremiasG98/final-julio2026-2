package model;

import org.junit.jupiter.api.Test;
import pelicula.exceptions.DatosObligatoriosException;
import pelicula.exceptions.FechaIngresoInvalidaException;
import pelicula.exceptions.SalarioInvalidoException;
import pelicula.modelo.Empleado;
import pelicula.modelo.Puesto;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmpleadoTest {
    @Test
    void shouldInstanciarEmpleadoSuccefully(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;

        Empleado empleado = Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario);

        assertEquals(nombre,empleado.getNombre());
        assertEquals(legajo,empleado.getLegajo());
        assertEquals(fechaIngreso,empleado.getFechaIngreso());
        assertEquals(puesto,empleado.getPuesto());
        assertEquals(salario,empleado.getSalario());
    }
    @Test
    void shouldThrowDatosObligatoriosException(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;

        assertThrows(DatosObligatoriosException.class, () ->
                    Empleado.instanciar(null,nombre,legajo,fechaIngreso,puesto,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,"  ",legajo,fechaIngreso,puesto,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,null,legajo,fechaIngreso,puesto,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,nombre,"  ",fechaIngreso,puesto,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,nombre,null,fechaIngreso,puesto,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,nombre,legajo,null,puesto,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,nombre,legajo,fechaIngreso,null,salario));
        assertThrows(DatosObligatoriosException.class, () ->
                Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,-1));
    }
    @Test
    void shouldThrowFechaIngresoinvalidaException(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now().plusDays(1);
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 850000;

        assertThrows(FechaIngresoInvalidaException.class,() -> Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario));

    }
    @Test
    void shouldThrowSalarioInvalidoException(){
        UUID id = UUID.randomUUID();
        String nombre = "Juan Perez";
        String legajo = "ABC1234";
        LocalDateTime fechaIngreso = LocalDateTime.now();
        Puesto puesto = Puesto.SUPERVISOR;
        double salario = 750000;

        Puesto puesto2 = Puesto.ANALISTA;
        double salario2 = 450000;

        Puesto puesto3 = Puesto.GERENTE;
        double salario3 = 1000000;

        assertThrows(SalarioInvalidoException.class, () -> Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto,salario));
        assertThrows(SalarioInvalidoException.class, () -> Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto2,salario2));
        assertThrows(SalarioInvalidoException.class, () -> Empleado.instanciar(id,nombre,legajo,fechaIngreso,puesto3,salario3));
    }
}
