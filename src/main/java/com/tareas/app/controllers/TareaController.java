package com.tareas.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareas.app.dtos.TareaDto;
import com.tareas.app.services.TareaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tareas")
public class TareaController {
	@Autowired
	private TareaService tareaService;

	@GetMapping("/obtener-todos")
	@ApiOperation("Obteniene la lista de todos las tareas")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<TareaDto>> listar() {
		return new ResponseEntity<>(tareaService.obtenerTodos(), HttpStatus.OK);
	}

	@PostMapping("/guardar")
	public ResponseEntity<TareaDto> guardar(@RequestBody TareaDto tareaDto) {
		return new ResponseEntity<>(tareaService.guardar(tareaDto), HttpStatus.CREATED);
	}

	@GetMapping("/obtener-por-id/{id}")
	@ApiOperation("Obtener una tarea por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Empleado no encontrado") })
	public ResponseEntity<TareaDto> obtenerPorId(
			@ApiParam(value = "Id de la tarea", required = true, example = "7") @PathVariable Long id) {
		TareaDto tareaDto = tareaService.obtenerTareaPorId(id);
		if (tareaDto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TareaDto>(tareaDto, HttpStatus.OK);
	}

	@PutMapping("/cambiar-estado/{id}")
	@ApiOperation("Cambia el estado una tarea por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Empleado no encontrado") })
	public ResponseEntity cambiarEstado(
			@ApiParam(value = "Id de la tarea", required = true, example = "7") @PathVariable("id") Long id,
			@RequestBody Long idEstado) {

		if (tareaService.CambiarEstado(id, idEstado)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	@ApiOperation("Elimina una tarea por id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Empleado no encontrado") })
	public ResponseEntity cambiarEstado(
			@ApiParam(value = "Id del empleado", required = true, example = "7") @PathVariable("id") Long id) {

		if (tareaService.eliminarTareaPorId(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
