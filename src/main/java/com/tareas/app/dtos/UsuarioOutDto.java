package com.tareas.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioOutDto {
	   private Long id;
		
		private String usuario;
		
		private LocalDate fechaRegistro;
		
		private LocalDate fechaActualizacion;
		
		private EstadoDto estado;

		private RolDto rol;
		
		private EmpleadoDto empleado;
}
