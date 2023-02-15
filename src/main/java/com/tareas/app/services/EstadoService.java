package com.tareas.app.services;

import com.tareas.app.dtos.EstadoDto;

public interface EstadoService {
	
	public EstadoDto findByNombreEstado(String nombre);
}
