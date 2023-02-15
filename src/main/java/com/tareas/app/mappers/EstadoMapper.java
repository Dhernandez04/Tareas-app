package com.tareas.app.mappers;

import org.mapstruct.Mapper;

import com.tareas.app.dtos.EstadoDto;
import com.tareas.app.entities.Estado;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
	
	
	EstadoDto toEstadoDto(Estado estado);
	
	
	Estado toEstado(EstadoDto estadodto);

}
