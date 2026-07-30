package ar.edu.undec.adapter.data.empleado.repoimplementacion;

import ar.edu.undec.adapter.data.empleado.crud.IEmpleadoCrudRepository;
import ar.edu.undec.adapter.data.empleado.mapper.EmpleadoMapper;
import ar.edu.undec.adapter.data.empleado.model.EmpleadoEntity;
import pelicula.modelo.Empleado;
import pelicula.output.IEmpleadoOutPut;

import java.util.List;
import java.util.Optional;

public class EmpleadoRepositoryImplementation implements IEmpleadoOutPut {
    private IEmpleadoCrudRepository repository;
    private EmpleadoMapper mapper;

    public EmpleadoRepositoryImplementation(IEmpleadoCrudRepository repository, EmpleadoMapper mapper){
        this.repository =  repository;
        this.mapper = mapper;
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        EmpleadoEntity entity = mapper.toEntity(empleado);
        EmpleadoEntity guardada = repository.save(entity);
        return mapper.toDomain(guardada);
    }

    @Override
    public Optional<Empleado> buscarEmpleadoPorLegajo(String legajo) {
        return repository.findByLegajo(legajo).map(mapper::toDomain);
    }

    @Override
    public List<Empleado> obtenerTodos() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
