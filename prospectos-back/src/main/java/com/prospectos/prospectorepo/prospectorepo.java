package com.prospectos.prospectorepo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prospectos.modelo.prospecto;
@Repository
public interface prospectorepo extends JpaRepository<prospecto,Long>{
    
}
