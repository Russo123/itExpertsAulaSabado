package com.itexpertes.exerciciospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itexpertes.exerciciospringboot.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
	

}
