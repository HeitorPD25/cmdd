package com.back.cmdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cmdd.model.RelatorioSemanal;

@Repository
public interface RelatorioSemanalRepository extends JpaRepository<RelatorioSemanal, Long> {
    
}
