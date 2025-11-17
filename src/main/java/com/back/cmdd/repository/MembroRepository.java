package com.back.cmdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cmdd.model.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
    
}
