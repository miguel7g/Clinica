package com.MiguelGomez7.Clinica.infra.Errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
       var errores = e.getFieldErrors().stream().map(DatosErrorDeValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    //se crea una clase dto DatosErrorDeValidacion interna dentro de esta clase

    private record DatosErrorDeValidacion(
            String error,
            String campo){

    //se crea un comstructor interno
    public  DatosErrorDeValidacion(FieldError error){
        this(error.getField(), error.getDefaultMessage());

         }
    }

}
