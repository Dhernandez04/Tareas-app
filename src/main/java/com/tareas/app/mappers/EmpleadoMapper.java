package com.tareas.app.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tareas.app.dtos.EmpleadoDto;
import com.tareas.app.entities.Empleado;


@Mapper(componentModel = "spring",uses = {UsuarioMapper.class})
public interface EmpleadoMapper {

	List<EmpleadoDto> toEmpleadoDtos(List<Empleado> empleados);
	
	Empleado toEmpleado(EmpleadoDto empleado);
	
	EmpleadoDto toEmpleadoDto(Empleado empleado);
}
