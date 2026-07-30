package ar.edu.undec.adapter.data.empleado.mapper;

import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import org.springframework.stereotype.Component;
import pelicula.modelo.Empleado;

@Component
public class EmpleadoMapper {
    public Empleado toDomain(EmpleadoEntity entity){
        return Empleado.instanciar(entity.getId(),entity.getNombre(),entity.getLegajo(),entity.getFechaIngreso(),entity.getPuesto(),entity.getSalario());
    }

    public EmpleadoEntity toEntity(Empleado empleado){
        return new EmpleadoEntity(empleado.getId(),empleado.getNombre(),empleado.getLegajo(),empleado.getFechaIngreso().toString(),empleado.getPuesto(),empleado.getSalario());
    }
}
