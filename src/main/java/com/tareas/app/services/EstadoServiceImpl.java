package com.tareas.app.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.app.dtos.EstadoDto;
import com.tareas.app.entities.Estado;
import com.tareas.app.mappers.EstadoMapper;



@Service
public class EstadoServiceImpl implements EstadoService{
	
	private static final Log LOGGER = LogFactory.getLog(RolServiceImpl.class);
	@PersistenceContext
    private	EntityManager em;

	@Autowired
	private EstadoMapper mapper;
	
	@Transactional(readOnly = true)
	@Override
	public EstadoDto findByNombreEstado(String nombre) {
		LOGGER.info("Iniciando metodo findByEstadoId()");
		Estado estado =  (Estado) em.createQuery("select * from Estado as e where e.nombre = :nombre")
				.setParameter("nombre", nombre). getSingleResult();
		LOGGER.info("Obteniendo informacion del estado: "+estado);
		LOGGER.info("Terminando metodo findByEstadoId()");
		return mapper.toEstadoDto(estado);
	}

}
