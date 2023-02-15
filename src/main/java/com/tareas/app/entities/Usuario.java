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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="usuario",unique = true)
	@NotEmpty
	private String usuario;
	
	@Column(name="clave")
	@NotEmpty
	private String clave;
	
	@Column(name="fecha_registro")
	private LocalDate fechaRegistro;
	
	@Column(name="fecha_actualizacion")
	private LocalDate fechaActualizacion;
	
	@Column(name="id_rol")
	private Long idRol;
	
	@Column(name="id_estado")
	private Long idEstado;
	
	@ManyToOne
	@JoinColumn(name = "id_estado",updatable = false,insertable = false)
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "id_rol",updatable = false,insertable = false)
	private Rol rol;

}
