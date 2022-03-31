package com.prospectos.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.prospectos.mensajes.mensajes;
import com.prospectos.modelo.modelo;
import com.prospectos.modelo.prospecto;
import com.prospectos.servicio.servicios;
import com.prospectos.servicio.servarchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
@Controller
@RestController
@RequestMapping
@CrossOrigin("*")
public class controlador {

    @Autowired
    private servicios servicios;
    private servarchivo servarchivo;
    @PostMapping("/guardararchivo")
    public ResponseEntity<?> guardararchivo(@RequestBody modelo modelo){return ResponseEntity.status(HttpStatus.CREATED).body(servarchivo.save(modelo));}    
    //actuaizar
    @PutMapping("/actualizar")
       public prospecto actualizar(@RequestBody prospecto prospectoobj){
           return servicios.save(prospectoobj);
    }
            //guardado de info
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody prospecto prospecto){return ResponseEntity.status(HttpStatus.CREATED).body(servicios.save(prospecto));}    
    //obtener info
    @GetMapping("/obtener")
    public List<prospecto>obtenertodo(){List<prospecto> prospectos=StreamSupport
        .stream(servicios.findAll().spliterator(), false)
        .collect(Collectors.toList());
    return prospectos;
    }  
    @GetMapping("/obtenerarc")
    public List<modelo>obtenert(){List<modelo> modelos=StreamSupport
        .stream(servarchivo.findAll().spliterator(), false)
        .collect(Collectors.toList());
    return modelos;
    }      
    @PostMapping("/upload")
    public ResponseEntity<mensajes> uploadFiles(@RequestParam("files")MultipartFile[] files){
        String message = "";
        try{
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file->{
                servicios.save(file);
                fileNames.add(file.getOriginalFilename());
            });

            message = "Se subieron los archivos correctamente " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new mensajes(message));
        }catch (Exception e){
            message = "Fallo al subir los archivos";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new mensajes(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<modelo>> getFiles(){
        List<modelo> fileInfos = servicios.loadAll().map(path -> {
          String filename = path.getFileName().toString();
          String url = MvcUriComponentsBuilder.fromMethodName(controlador.class, "getFile",
                  path.getFileName().toString()).build().toString();
          long id=0;
          /*String nombreprospecto="";
          String primerapellidoprospecto="";
          String segundoapellidoprospecto="";
          String calleprospecto="";
          String numeroprospecto="";
          String coloniaprospecto="";
          String codigopostalprospecto="";
          String telefonoprospecto="";
          String rfcprospecto="";*/
          return new modelo(id,filename, url);
          //,nombreprospecto,primerapellidoprospecto,segundoapellidoprospecto,calleprospecto,numeroprospecto,coloniaprospecto,codigopostalprospecto,telefonoprospecto,rfcprospecto);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = servicios.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename() + "\"").body(file);
    }

    @GetMapping("/delete/{filename:.+}")
    public ResponseEntity<mensajes> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            message = servicios.deleteFile(filename);
            return ResponseEntity.status(HttpStatus.OK).body(new mensajes(message));
        } catch (IOException e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new mensajes(message));
        }
    }



}
