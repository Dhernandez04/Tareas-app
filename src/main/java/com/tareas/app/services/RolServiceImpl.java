package com.tareas.app.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.app.dtos.RolDto;
import com.tareas.app.entities.Rol;
import com.tareas.app.mappers.RolMapper;


@Service
public class RolServiceImpl implements RolService{
	
	private static final Log LOGGER = LogFactory.getLog(RolServiceImpl.class);
	@PersistenceContext
    private	EntityManager em;
	

	@Autowired
	private RolMapper mapper;

	@Transactional(readOnly = true)
	@Override
	public List<RolDto> obtenerRoles() {
		LOGGER.info("Iniciando metodo obtenerRoles()");
		List<Rol> roles =  (List<Rol>) em.createQuery("select * from Rol").getSingleResult();
		LOGGER.info("Obteniendo roles: "+roles);
		LOGGER.info("Terminando metodo obtenerRoles()");
		return mapper.toRolDto(roles);
	}
	

}
