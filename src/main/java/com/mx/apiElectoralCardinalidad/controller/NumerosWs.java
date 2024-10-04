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

import com.mx.apiElectoralCardinalidad.model.Numeros;
import com.mx.apiElectoralCardinalidad.service.NumerosImp;

@RestController
@RequestMapping("NumerosWs")
@CrossOrigin
public class NumerosWs {

	@Autowired
	NumerosImp imp;

	// http://localhost:9000/NumerosWs/listar
	@GetMapping("listar")
	public List<Numeros> listar() {
		return imp.listar();
	}

	// http://localhost:9000/NumerosWs/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Numeros numero) {
		imp.guardar(numero);
		return new ResponseEntity<>(numero, HttpStatus.CREATED);
	}

	// http://localhost:9000/NumerosWs/buscar
	@PostMapping("buscar")
	public Numeros buscar(@RequestBody Numeros numero) {
		return imp.buscar(numero.getId());
	}

	// http://localhost:9000/NumerosWs/editar
	@PostMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Numeros numero) {
		imp.editar(numero);
		return new ResponseEntity<>(numero, HttpStatus.CREATED);
	}

	// http://localhost:9000/NumerosWs/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Numeros numero) {
		imp.eliminar(numero.getId());
		return new ResponseEntity<>("Se elimino con exito", HttpStatus.OK);
	}
}
