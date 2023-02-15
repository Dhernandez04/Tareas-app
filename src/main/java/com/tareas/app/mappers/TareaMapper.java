package com.tareas.app.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tareas.app.dtos.TareaDto;
import com.tareas.app.entities.Tarea;

@Mapper(componentModel = "spring",uses = {UsuarioMapper.class,EmpleadoMapper.class})
public interface TareaMapper {
	
	List<TareaDto> toTareaDtos(List<Tarea> tareas);
	
	
	TareaDto toTareaDto(Tarea tarea);
	
	Tarea toTarea(TareaDto tareaDto);
	
}
