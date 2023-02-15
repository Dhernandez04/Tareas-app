package com.tareas.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="nombre")
	@NotEmpty
	private String nombre;

	@Column(name="descripcion")
	@NotEmpty
	private String descripcion;

	@Column(name="id_estado")
	@NotEmpty
	private Long idEstado;
	

	@Column(name="id_supervisor")
	@NotEmpty
	private Long idSupervisor;

	@Column(name="id_empleado")
	@NotEmpty
	private Long idEmpleado;
	
	@Column(name="fecha_registro")
	private LocalDate fechaRegistro;
	
	@Column(name="fecha_actualizacion")
	private LocalDate fechaActualizacion;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado",updatable = false,insertable = false)
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "id_supervisor",updatable = false,insertable = false)
	private Usuario supervisor;

}
