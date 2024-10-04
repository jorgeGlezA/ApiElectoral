package com.mx.apiElectoralCardinalidad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.apiElectoralCardinalidad.dao.NumerosDao;
import com.mx.apiElectoralCardinalidad.model.Numeros;

@Service
public class NumerosImp {

	@Autowired
	NumerosDao numerosDao;
	
	public List<Numeros> listar (){
		return numerosDao.findAll();
	}
	
	// Guardar -- idNum no se repita, numero no se repita y idPersonaExista
	
	public String guardar(Numeros numero) {
		numerosDao.save(numero);
		
		// personasDao -- recorrer
		// numerosDao -- recorrer
		
		return "guardado";
	}
	
	public Numeros buscar(Long id) {
		return numerosDao.findById(id).orElse(null);
	}
	
	//Que el idNumero exista y el idPersona exista
	public String editar(Numeros numero) {
		numerosDao.save(numero);
		return "guardado";
	}
	
	// que el idNumero exista
	public boolean eliminar (Long id) {
		numerosDao.deleteById(id);
		return false;
	}
	
}
