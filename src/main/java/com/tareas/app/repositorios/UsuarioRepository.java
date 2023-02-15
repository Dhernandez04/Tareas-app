package com.tareas.app.repositorios;




import org.springframework.data.repository.CrudRepository;


import com.tareas.app.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
