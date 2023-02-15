package com.tareas.app.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.tareas.app.entities.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{

}
