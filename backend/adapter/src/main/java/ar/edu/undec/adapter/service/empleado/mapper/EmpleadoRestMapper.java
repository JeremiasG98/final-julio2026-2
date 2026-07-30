package ar.edu.undec.adapter.service.empleado.mapper;

import ar.edu.undec.adapter.service.empleado.model.EmpleadoDtoRequest;
import ar.edu.undec.adapter.service.empleado.model.EmpleadoDtoResponse;
import pelicula.modelo.Empleado;

public class EmpleadoRestMapper {
//    public Empleado toDomain(EmpleadoDtoRequest request){
//        return Empleado.instanciar(request.id(),request.nombre(),request.legajo(),request.fechaIngreso(),request.puesto(),request.salario());
//    }

    public EmpleadoDtoResponse toResponse(Empleado empleado){
        return new EmpleadoDtoResponse(empleado.getId().toString(),empleado.getNombre(),empleado.getLegajo(),empleado.getFechaIngreso().toString(),empleado.getPuesto().toString(),empleado.getSalario());
    }
}
