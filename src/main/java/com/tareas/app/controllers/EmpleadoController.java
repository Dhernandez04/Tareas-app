package com.tareas.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareas.app.dtos.EmpleadoDto;
import com.tareas.app.services.EmpleadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/empleados")
@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/obtener-todos")
	@ApiOperation("Obteniene la lista de todos los empleados")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<EmpleadoDto>> obtenerTodos() {
		return new ResponseEntity<>(empleadoService.obtenerTodos(), HttpStatus.OK);
	}

	@GetMapping("/buscar-por-id/{id}")
	@ApiOperation("Buscar un empleado por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Empleado no encontrado") })
	public ResponseEntity<EmpleadoDto> buscarPorId(
			@ApiParam(value = "Id del empleado", required = true, example = "7") @PathVariable Long id) {

		EmpleadoDto empleadoDto = empleadoService.obtenerEmpleadoPorId(id);
		if (empleadoDto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleadoDto, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{id}")
	@ApiOperation("Eliminar un empleado por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Empleado no encontrado") })
	public ResponseEntity eliminar(
			@ApiParam(value = "Id del empleado", required = true, example = "7") @PathVariable("id") Long id) {
		if (empleadoService.eliminarEmpleado(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
