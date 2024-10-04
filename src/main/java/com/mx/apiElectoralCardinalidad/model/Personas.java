package com.mx.apiElectoralCardinalidad.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE PERSONAR_TEL(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2 (50) NOT NULL,
APP VARCHAR2 (50) NOT NULL,
APM VARCHAR2 (50)
);
*/

@Entity
@Table(name="PERSONAR_TEL")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personas {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APP")
	private String app;
	
	@Column(name = "APM")
	private String apm;
	
	// CARDINALIDAD -- Una persona tiene muchos numeros de celular
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL) //mappedBy -- Define el lado de referencia, el lado de propiedad
	@JsonIgnore  //Ignorar una propiedad o lista de propiedades
	List<Numeros> lista = new ArrayList<>();
	
	
}
