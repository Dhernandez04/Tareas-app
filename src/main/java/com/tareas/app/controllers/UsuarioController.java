package com.tareas.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareas.app.dtos.EmpleadoDto;
import com.tareas.app.dtos.UsuarioDto;
import com.tareas.app.dtos.UsuarioInDto;
import com.tareas.app.dtos.UsuarioOutDto;
import com.tareas.app.entities.Usuario;
import com.tareas.app.services.EmpleadoService;
import com.tareas.app.services.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/obtener-todos")
	@ApiOperation("Obteniene la lista de todos los usuarios")
	@ApiResponse(code = 200, message = "OK")
	ResponseEntity<List<UsuarioDto>> obtenerTodos() {
		return new ResponseEntity<>(usuarioService.obtenerTodos(), HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	@ApiOperation("Eliminar un usuario por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Empleado no encontrado") })
	public ResponseEntity eliminar(
			@ApiParam(value = "Id del empleado", required = true, example = "7") @PathVariable("id") Long id,
			@Param("estado") Long idEstado) {
		if (usuarioService.eliminarUsuarioPorId(id, idEstado)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/guardar")
	@ApiOperation("Guarda la informacion del usuario y se asigna a un empleado")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<UsuarioOutDto> guardar(@RequestBody UsuarioInDto usuarioInDto){
		
		UsuarioOutDto usuariOutDto = usuarioService.guardar(usuarioInDto);
		
	
		return new ResponseEntity<>(usuariOutDto, HttpStatus.OK);
	}
	
	
	
}
