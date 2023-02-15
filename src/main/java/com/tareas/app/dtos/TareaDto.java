package com.tareas.app.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDto {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private Long idEstado;
	private Long idSupervisor;
	private Long idEmpleado;
	private LocalDate fechaRegistro;
	private LocalDate fechaActualizacion;
	private EmpleadoDto empleadoDto;
	private UsuarioDto supervisorDto;
}
