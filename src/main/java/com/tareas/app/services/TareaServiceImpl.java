package com.tareas.app.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.app.dtos.TareaDto;
import com.tareas.app.entities.Tarea;
import com.tareas.app.mappers.TareaMapper;
import com.tareas.app.repositorios.TareaRepository;


@Service
public class TareaServiceImpl implements TareaService{
	private static final Log LOGGER = LogFactory.getLog(TareaServiceImpl.class);
	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	private TareaMapper mapper;
	@Transactional(readOnly=true)
	@Override
	public List<TareaDto> obtenerTodos() {
		LOGGER.info("Inicia metodo obtenerTodos()");
		List<Tarea> tareas = (List<Tarea>) tareaRepository.findAll();
		LOGGER.info("Termina metodo obtenerTodos()");
		return mapper.toTareaDtos(tareas);
	}
	@Transactional
	@Override
	public TareaDto guardar(TareaDto tareaDto) {
		LOGGER.info("Inicia metodo guardar()");
		Tarea tarea = mapper.toTarea(tareaDto);
		LOGGER.info("Recibiendo objeto tarea: "+tarea);
		TareaDto tareaDtoDB = mapper.toTareaDto(tareaRepository.save(tarea));
		LOGGER.info("Termina metodo guardar()");
		return tareaDtoDB;
	}
	@Transactional(readOnly=true)
	@Override
	public TareaDto obtenerTareaPorId(Long id) {
		LOGGER.info("Inicia metodo obtenerTareaPorId()");
		Tarea tarea = tareaRepository.findById(id).orElse(null);
		LOGGER.info("Tarea encontrada: "+tarea);
		
		LOGGER.info("Termina metodo obtenerTareaPorId()");
		return mapper.toTareaDto(tarea);
	}
	@Transactional
	@Override
	public Boolean CambiarEstado(Long id,Long idEstado) {
		LOGGER.info("Inicia metodo CambiarEstado()");
		TareaDto tareaDto = obtenerTareaPorId(id);
		tareaDto.setIdEstado(idEstado);
		if(tareaDto.getId() != null) {
			tareaRepository.save(mapper.toTarea(tareaDto));
			return true;
		}else {
			LOGGER.info("El estado  de la tarea no se pudo modificar.");
		}
		LOGGER.info("Termina metodo CambiarEstado()");
		return false;
		
	}
	@Transactional
	@Override
	public Boolean eliminarTareaPorId(Long id) {
		LOGGER.info("Inicia metodo eliminarTareaPorId()");
		TareaDto tareaDto =obtenerTareaPorId(id);
		if(tareaDto.getId() != null) {

			tareaRepository.deleteById(id);
			return true;
		}else {
			LOGGER.info("El estado del usuario no se pudo modificar.()");
			
		}
		LOGGER.info("Termina metodo eliminarTareaPorId()");
		return false;
	}

}
