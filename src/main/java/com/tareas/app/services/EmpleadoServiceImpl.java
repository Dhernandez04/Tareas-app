package com.tareas.app.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.app.dtos.EmpleadoDto;
import com.tareas.app.entities.Empleado;
import com.tareas.app.mappers.EmpleadoMapper;
import com.tareas.app.repositorios.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	private static final Log LOGGER = LogFactory.getLog(EmpleadoServiceImpl.class);
	

	private EmpleadoRepository  empleadoRepository;
	
	private EmpleadoMapper mapper;
	
	
	@Autowired
	public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, EmpleadoMapper mapper) {
		this.empleadoRepository = empleadoRepository;
		this.mapper = mapper;
	}
	@Transactional(readOnly=true)
	@Override
	public List<EmpleadoDto> obtenerTodos() {
		LOGGER.info("Inicia metodo obtenerTodos()");

		List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
		
		LOGGER.info("Termina metodo obtenerTodos()");
		return mapper.toEmpleadoDtos(empleados);
	}
	@Transactional
	@Override
	public EmpleadoDto guardar(EmpleadoDto empleadoDto) {
		LOGGER.info("Inicia metodo guardar()");
		Empleado empleado = mapper.toEmpleado(empleadoDto);
		LOGGER.info("Recibiendo objeto empleado: "+empleado);
		EmpleadoDto empleadoDtoDB = mapper.toEmpleadoDto(empleadoRepository.save(empleado));
		LOGGER.info("Termina metodo guardar()");
		return empleadoDtoDB;
	}
	@Transactional(readOnly=true)
	@Override
	public EmpleadoDto obtenerEmpleadoPorId(Long id) {
		LOGGER.info("Inicia metodo obtenerUsuarioPorId()");
		LOGGER.info("Id recibido: "+id);
		Empleado empleado = empleadoRepository.findById(id).orElse(null);
		LOGGER.info("Empleado encontrado: "+empleado);
		LOGGER.info("Termina metodo obtenerUsuarioPorId()");
		return mapper.toEmpleadoDto(empleado);
	}
	@Override
	public Boolean eliminarEmpleado(Long id) {
		LOGGER.info("Inicia metodo eliminarEmpleado()");
		LOGGER.info("Id recibido: "+id);
		EmpleadoDto empeladoDto = obtenerEmpleadoPorId(id);
		if(empeladoDto == null) {
			LOGGER.info("No se pudo encontrar el empleado a eliminar");
			return false;
		}
		empleadoRepository.deleteById(id);
		LOGGER.info("Termina metodo eliminarEmpleado()");
		return true;
	}


}
