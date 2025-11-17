package com.back.cmdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cmdd.model.Celula;

@Repository
public interface CelulaRepository extends JpaRepository<Celula, Long> {
    
}
