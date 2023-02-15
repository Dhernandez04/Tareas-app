package com.tareas.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInDto {
	
    private Long id;
	
	private String usuario;
	
	private String clave;
	
	private LocalDate fechaRegistro;
	
	private LocalDate fechaActualizacion;
	
	private EstadoDto estado;

	private RolDto rol;
	
	private EmpleadoDto empleadoDto;
}
