package com.tareas.app.services;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.app.dtos.EmpleadoDto;
import com.tareas.app.dtos.UsuarioDto;
import com.tareas.app.dtos.UsuarioInDto;
import com.tareas.app.dtos.UsuarioOutDto;
import com.tareas.app.entities.Empleado;
import com.tareas.app.entities.Usuario;
import com.tareas.app.mappers.EmpleadoMapper;
import com.tareas.app.mappers.UsuarioMapper;
import com.tareas.app.repositorios.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioServiceImpl.class);

	private UsuarioRepository usuarioRepository;

	private EmpleadoService empleadoService;

	private UsuarioMapper mapper; 

	private EmpleadoMapper mapperEmpleado;
	
	
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, EmpleadoService empleadoService,
			UsuarioMapper mapper, EmpleadoMapper mapperEmpleado) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.empleadoService = empleadoService;
		this.mapper = mapper;
		this.mapperEmpleado = mapperEmpleado;
	}

	@Transactional(readOnly = true)
	@Override
	public List<UsuarioDto> obtenerTodos() {
		
		LOGGER.info("Inicia metodo obtenerTodos()");
		List<Usuario> usuarios  =  (List<Usuario>) usuarioRepository.findAll();
		LOGGER.info("Termina metodo obtenerTodos()");
		return mapper.toUsuarioDtos(usuarios);
	}
	
	@Transactional
	@Override
	public UsuarioOutDto guardar(UsuarioInDto usuarioInDto) {
		LOGGER.info("Inicia metodo guardar()");
		
		Usuario usuario = mapper.toUsuario(usuarioInDto);
		
		LOGGER.info("Recibiendo objeto usuario: "+usuario);
		
		UsuarioDto usuarioDto= mapper.toUsuarioDto(usuarioRepository.save(usuario));
		
		//Asignando el id del usuario al empleado
		usuarioInDto.getEmpleadoDto().setId(usuarioDto.getId());
		
		//Almacenando informacion del empleado
		EmpleadoDto empleadoDto = empleadoService.guardar(usuarioInDto.getEmpleadoDto());
		
		//mapeando los datos
		UsuarioOutDto UsuarioOutDto = mapper.toUsuarioDto(usuarioDto);
		UsuarioOutDto.setEmpleado(empleadoDto);
		LOGGER.info("Termina metodo guardar()");
		return UsuarioOutDto;
	}
	
	@Transactional(readOnly = true)
	@Override
	public UsuarioDto obtenerUsuarioPorId(Long id) {
		
		LOGGER.info("Inicia metodo obtenerUsuarioPorId()");
		LOGGER.info("Id recibido: "+id);
			Usuario usuario = usuarioRepository.findById(id).orElse(null);
			LOGGER.info("Usuario encontrado: "+usuario);
			LOGGER.info("Termina metodo obtenerUsuarioPorId()");
		return mapper.toUsuarioDto(usuario);
		
	}
	
	@Transactional
	@Override
	public Boolean eliminarUsuarioPorId(Long id,Long idEstado) {
		
		LOGGER.info("Inicia metodo eliminarUsuarioPorId()");
		UsuarioDto usuarioDto = obtenerUsuarioPorId(id);
		usuarioDto.setIdEstado(idEstado);
		LOGGER.info("Usuario modificado"+usuarioDto);
		if(usuarioDto.getId() != null) {

			usuarioRepository.save(mapper.toUsuario(usuarioDto));
			return true;
		}else {
			LOGGER.info("El estado del usuario no se pudo modificar.()");
			
		}
		LOGGER.info("Termina metodo eliminarUsuarioPorId()");
		return false;
	}

}
