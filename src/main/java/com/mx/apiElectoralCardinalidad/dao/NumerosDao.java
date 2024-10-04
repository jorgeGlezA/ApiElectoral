package com.mx.apiElectoralCardinalidad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiElectoralCardinalidad.model.Numeros;

public interface NumerosDao extends JpaRepository<Numeros, Long> {

}
