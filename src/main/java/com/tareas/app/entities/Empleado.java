package com.tareas.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="empleados")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="numero_documento")
	private String numeroDocumento;

	@Column(name="nombres")
	private String nombres;

	@Column(name="apellidos")
	private String apellidos;
	
	
	@Column(name="fecha_registro")
	private LocalDate fechaRegistro;
	
	@Column(name="fecha_actualizacion")
	private LocalDate fechaActualizacion;
	
	@Column(name="id_usuario")
	private Long idUsuario;
	
	@OneToOne
	@JoinColumn(name = "id_usuario",updatable = false,insertable = false)
	private Usuario usuario;

}
