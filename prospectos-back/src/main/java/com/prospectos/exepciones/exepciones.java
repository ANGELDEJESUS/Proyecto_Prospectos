package com.prospectos.exepciones;

import com.prospectos.mensajes.mensajes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class exepciones {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<mensajes> maxSizeException(MaxUploadSizeExceededException exc){
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new mensajes("Uno o mas archivos exceden el tamaño maximo"));
    }

}
