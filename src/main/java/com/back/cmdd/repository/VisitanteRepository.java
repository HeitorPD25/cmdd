package com.back.cmdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cmdd.model.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
    
}
