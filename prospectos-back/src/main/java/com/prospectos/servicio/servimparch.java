package com.prospectos.servicio;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.prospectos.modelo.modelo;
import com.prospectos.modelo.prospecto;
import com.prospectos.prospectorepo.prospectorepo;
import com.prospectos.modelorepo.modelorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
@Service
public class servimparch implements servarchivo{
  public void init(){};

    @Autowired
    private modelorepo modelos;

    //barrido de prospectos
    @Override
    @Transactional(readOnly = true)
    public  Iterable<modelo>findAll() {
        return modelos.findAll();
    }
    //save prospecto
    @Override
    @Transactional(readOnly = true)
    public  Page<modelo>findAll(Pageable pageable) {
      return modelos.findAll(pageable);        
    }
    @Override
    @Transactional
    public  modelo save(modelo modelo) {
      return modelos.save(modelo);        
    }
   
}
