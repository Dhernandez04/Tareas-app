package com.tareas.app.services;


import java.util.List;



import com.tareas.app.dtos.UsuarioDto;
import com.tareas.app.dtos.UsuarioInDto;
import com.tareas.app.dtos.UsuarioOutDto;


public interface UsuarioService {

	public List<UsuarioDto> obtenerTodos();
	
	public UsuarioOutDto guardar(UsuarioInDto usuarioInDto);
	
	public UsuarioDto obtenerUsuarioPorId(Long id);
	
	public Boolean eliminarUsuarioPorId(Long id,Long idEstado);
	
}
