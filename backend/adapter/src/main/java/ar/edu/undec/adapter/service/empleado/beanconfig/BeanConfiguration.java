package ar.edu.undec.adapter.service.empleado.beanconfig;

import ar.edu.undec.adapter.data.empleado.crud.IEmpleadoCrudRepository;
import ar.edu.undec.adapter.data.empleado.mapper.EmpleadoMapper;
import ar.edu.undec.adapter.data.empleado.repoimplementacion.EmpleadoRepositoryImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pelicula.input.IBuscarEmpleadoPorLegajoInput;
import pelicula.input.ICrearEmpleadoInput;
import pelicula.input.IObtenerEmpleadosInput;
import pelicula.output.IEmpleadoOutPut;
import pelicula.usecase.BuscarEmpleadoPorLegajoUseCase;
import pelicula.usecase.CrearEmpleadoUseCase;
import pelicula.usecase.ObtenerEmpleadosUseCase;

@Configuration
public class BeanConfiguration {
    @Bean
    public IEmpleadoOutPut empleadoOutPut(IEmpleadoCrudRepository repository, EmpleadoMapper mapper){
        return new EmpleadoRepositoryImplementation(repository, mapper);
    }
    @Bean
    public ICrearEmpleadoInput crearEmpleado (IEmpleadoOutPut outPut){
        return new CrearEmpleadoUseCase(outPut);
    }
    @Bean
    public IBuscarEmpleadoPorLegajoInput buscarEmpleadoPorLegajo (IEmpleadoOutPut outPut){
        return new BuscarEmpleadoPorLegajoUseCase(outPut);
    }
    @Bean
    public IObtenerEmpleadosInput obtenerEmpleados(IEmpleadoOutPut outPut){
        return new ObtenerEmpleadosUseCase(outPut);
    }

}
