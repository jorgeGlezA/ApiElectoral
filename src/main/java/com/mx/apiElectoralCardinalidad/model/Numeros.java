package com.mx.apiElectoralCardinalidad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 
 CREATE TABLE NUMEROS_PER (
ID NUMBER PRIMARY KEY,
LADA NUMBER NOT NULL,
NUMERO NUMBER NOT NULL,
ID_PERSONA NUMBER NOT NULL,
FOREIGN KEY (ID_PERSONA) REFERENCES PERSONAR_TEL(ID)
);
 */

@Entity
@Table(name = "NUMEROS_PER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Numeros {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LADA")
	private Integer lada;
	
	@Column(name = "NUMERO")
	private Long numero;
	
	// Cardinalidad -- Muchos numeros le pertenecen a una persona
	// fecth -- indica como debe ser cargada la entidad
	// FetchType -- indicamos que la relación debe ser cargada al momento
	// Aqui no va e ignore porque si queremos que el constructor vaya el objeto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PERSONA")
	Personas persona;
}
