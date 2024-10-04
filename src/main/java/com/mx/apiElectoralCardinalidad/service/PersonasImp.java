package com.mx.apiElectoralCardinalidad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiElectoralCardinalidad.dao.PersonasDao;
import com.mx.apiElectoralCardinalidad.model.Personas;

@Service
public class PersonasImp {

	@Autowired
	PersonasDao dao;

	public List<Personas> listar() {
		return dao.findAll();
	}

	// Guardar -- id no se repita, nombre completo no se repita
	public String guardar(Personas persona) {

		boolean bandera = false;
		String respuesta = "";

		for (Personas p : listar()) {
			if (p.getId().equals(persona.getId())) {
				respuesta = "existeId";
				break;
			}

			String nameCompleoAlmacenado = p.getNombre() + p.getApp() + p.getApm();
			String nameCompletIngresado = persona.getNombre() + persona.getApp() + persona.getApm();
			if (nameCompleoAlmacenado.equals(nameCompletIngresado)) {
				respuesta = "nombreExiste";
				break;
			}
		}

		if (respuesta.equals("")) {
			dao.save(persona);
		}
		return respuesta;
	}

	public Personas buscar(Long id) {
		return dao.findById(id).orElse(null);
	}

	// ID exista
	public boolean editar(Personas persona) {

		boolean bandera = false;
		for (Personas p : listar()) {
			if (p.getId().equals(persona.getId())) {
				bandera = true;
				break;
			}
		}

		if (bandera == true)
			dao.save(persona);

		return bandera;
	}

	// ID exista
	public boolean eliminar(Long id) {

		boolean bandera = false;
		for (Personas p : listar()) {
			if (p.getId().equals(id)) {
				bandera = true;
				break;
			}
		}

		if (bandera == true)
			dao.deleteById(id);
		
		return bandera;
	}

}
