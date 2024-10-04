package com.mx.apiElectoralCardinalidad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiElectoralCardinalidad.model.Personas;
import com.mx.apiElectoralCardinalidad.service.PersonasImp;

@RestController
@RequestMapping(path = "Personas")
@CrossOrigin
public class PersonasWS {

	@Autowired
	PersonasImp imp;

	// http://localhost:9000/Personas/listar
	@GetMapping("listar")
	public List<Personas> listar() {
		return imp.listar();
	}

	// http://localhost:9000/Personas/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Personas persona) {
		String respuesta = imp.guardar(persona);

		if (respuesta.equals("existeId")) {
			return new ResponseEntity<>("Ese registro ya existe, no se puede guardar", HttpStatus.OK);
		} else if (respuesta.equals("nombreExiste")) {
			return new ResponseEntity<>("Ese nombre ya existe, ingrese otro nombre", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(persona, HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/Personas/buscar
	@PostMapping("buscar")
	public Personas buscar(@RequestBody Personas persona) {
		return imp.buscar(persona.getId());
	}

	// http://localhost:9000/Personas/editar
	@PostMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Personas persona) {
		boolean bandera = imp.editar(persona);

		if (bandera == false) {
			return new ResponseEntity<>("Ese registro no existe, no se puede editar", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(persona, HttpStatus.CREATED);
		}
	}

	// http://localhost:9000/Personas/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Personas persona) {
		boolean bandera = imp.eliminar(persona.getId());

		if (bandera == false) {
			return new ResponseEntity<>("No existe, no se puede eliminar", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Se elimino con exito", HttpStatus.OK);
		}
	}

}
