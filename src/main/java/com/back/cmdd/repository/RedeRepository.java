package com.back.cmdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cmdd.model.Rede;

@Repository
public interface RedeRepository extends JpaRepository<Rede, Long> {
    
}
