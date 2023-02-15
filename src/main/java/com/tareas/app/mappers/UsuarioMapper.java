package com.tareas.app.mappers;

import java.util.List;


import org.mapstruct.Mapper;

import com.tareas.app.dtos.UsuarioDto;
import com.tareas.app.dtos.UsuarioInDto;
import com.tareas.app.dtos.UsuarioOutDto;
import com.tareas.app.entities.Usuario;

@Mapper(componentModel = "spring",uses = {RolMapper.class,EstadoMapper.class})
public interface UsuarioMapper {
	
	UsuarioDto toUsuarioDto(Usuario usuario);
	
	UsuarioOutDto toUsuarioDto(UsuarioDto usuarioDto);
	
	List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios);
	
	Usuario toUsuario(UsuarioDto usuarioDto);
	
	Usuario toUsuario(UsuarioInDto usuario);
	
	
}