package com.tareas.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {
	
	private Long id;
	private String numeroDocumento;
	private String nombres;
	private String apellidos;
	private LocalDate fechaRegistro;
	private LocalDate fechaActualizacion;
	private Long idUsuario;
	private UsuarioDto usuarioDto;
}
