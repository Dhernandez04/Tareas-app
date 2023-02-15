package com.tareas.app.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tareas.app.entities.Tarea;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long>{

}
