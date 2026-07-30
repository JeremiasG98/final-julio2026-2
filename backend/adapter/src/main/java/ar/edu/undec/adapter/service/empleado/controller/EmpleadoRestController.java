package ar.edu.undec.adapter.service.empleado.controller;

import ar.edu.undec.adapter.service.empleado.mapper.EmpleadoRestMapper;
import ar.edu.undec.adapter.service.empleado.model.EmpleadoDtoRequest;
import ar.edu.undec.adapter.service.empleado.model.EmpleadoDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pelicula.input.IBuscarEmpleadoPorLegajoInput;
import pelicula.input.ICrearEmpleadoInput;
import pelicula.input.IObtenerEmpleadosInput;
import pelicula.modelo.Empleado;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController {

    private ICrearEmpleadoInput crearEmpleadoInput;
    private IBuscarEmpleadoPorLegajoInput buscarEmpleadoPorLegajo;
    private IObtenerEmpleadosInput obtenerEmpleados;
    private EmpleadoRestMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDtoResponse crearEmpleado(@RequestBody EmpleadoDtoRequest request){
        Empleado empleado = crearEmpleadoInput.ejecutar(request.nombre(),request.legajo(),request.fechaIngreso(),request.puesto(),request.salario());
        return mapper.toResponse(empleado);
    }
    @GetMapping("/{id}")
    public EmpleadoDtoResponse buscarEmpleadoPorLegajo (@PathVariable String legajo){
        Empleado empleado = buscarEmpleadoPorLegajo(legajo).get();
        return mapper.toResponse(empleado);
    }
    @GetMapping
    public List<EmpleadoDtoResponse> obtenerEmpleados(){
        return obtenerEmpleados.ejecutar().stream().map(mapper::toResponse).toList();
    }

}
