package pelicula.modelo;

import lombok.Getter;
import pelicula.exceptions.DatosObligatoriosException;
import pelicula.exceptions.FechaIngresoInvalidaException;
import pelicula.exceptions.SalarioInvalidoException;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Empleado {
    private UUID id;
    private String nombre;
    private String legajo;
    private LocalDateTime fechaIngreso;
    private Puesto puesto;
    private double salario;

    private Empleado(UUID id, String nombre, String legajo, LocalDateTime fechaIngreso, Puesto puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.legajo = legajo;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salario = salario;
    }
    public static Empleado instanciar(UUID id, String nombre, String legajo, LocalDateTime fechaIngreso, Puesto puesto, double salario){
        if(id == null || nombre == null || nombre.isBlank() || legajo == null || legajo.isBlank() || fechaIngreso == null || puesto == null || salario < 0){
            throw new DatosObligatoriosException("Los datos son obligatorios");
        }
        if(fechaIngreso.isAfter(LocalDateTime.now())){
            throw new FechaIngresoInvalidaException("La fecha no puede ser superior a la actual.");
        }
        if(puesto == Puesto.ANALISTA && salario < 500000){
            throw new SalarioInvalidoException("El salario de ANALISTA debe ser mayor a 50000");
        }
        if(puesto == Puesto.SUPERVISOR && salario < 800000){
            throw new SalarioInvalidoException("El salario de SUPERVISOR debe ser mayor a 800000");
        }
        if(puesto == Puesto.GERENTE && salario < 1200000){
            throw new SalarioInvalidoException("El salario de GERENTE debe ser mayor a 1200000");
        }
        return new Empleado(id,nombre,legajo,fechaIngreso,puesto,salario);
    }
}
