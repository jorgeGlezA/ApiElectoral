package com.mx.apiElectoralCardinalidad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiElectoralCardinalidad.model.Personas;

public interface PersonasDao extends JpaRepository<Personas, Long> {

}
