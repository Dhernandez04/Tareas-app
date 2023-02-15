package com.tareas.app.services;

import java.util.List;

import com.tareas.app.dtos.TareaDto;


public interface TareaService {
	public List<TareaDto> obtenerTodos();
	
	public TareaDto guardar(TareaDto tareaDto);
	
	public TareaDto obtenerTareaPorId(Long id);

	Boolean CambiarEstado(Long id, Long idEstado);
	
	Boolean eliminarTareaPorId(Long id);
}
