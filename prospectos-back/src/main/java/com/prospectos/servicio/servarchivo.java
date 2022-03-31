package com.prospectos.servicio;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.prospectos.modelo.modelo;
import com.prospectos.modelo.prospecto;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;
public interface servarchivo {
    public Iterable<modelo>findAll();
    public Page<modelo>findAll(Pageable pageable);
    public modelo save(modelo modelo);
    public void init();
     
    

    
  

    /*
    Metodo para Borrar un archivo
     */

}
