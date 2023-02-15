package com.tareas.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	
	private Long id;
	
	private String usuario;
	
	private LocalDate fechaRegistro;
	
	private LocalDate fechaActualizacion;
	
	private EstadoDto estadoDto;
    private Long idRol;
	private Long idEstado;
	private RolDto rolDto;
}
