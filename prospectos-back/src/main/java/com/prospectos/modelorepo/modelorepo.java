package com.prospectos.modelorepo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prospectos.modelo.modelo;
@Repository
public interface  modelorepo extends JpaRepository<modelo,Long> {
    
}
