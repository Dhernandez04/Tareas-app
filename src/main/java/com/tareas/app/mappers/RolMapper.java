package com.tareas.app.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tareas.app.dtos.RolDto;
import com.tareas.app.entities.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {
	
	List<RolDto> toRolDto(List<Rol> roles);
	
	
	Rol toRol(RolDto rolDto);
}
