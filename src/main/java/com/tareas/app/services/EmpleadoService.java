package com.tareas.app.services;

import java.util.List;

import com.tareas.app.dtos.EmpleadoDto;

public interface EmpleadoService {
	public List<EmpleadoDto> obtenerTodos();
	
	public EmpleadoDto guardar(EmpleadoDto empleadoDto);
	
	public EmpleadoDto obtenerEmpleadoPorId(Long id);
	
	public Boolean eliminarEmpleado(Long id);
}
