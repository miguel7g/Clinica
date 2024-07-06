package com.MiguelGomez7.Clinica.infra.Errores;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String text){
        super(text);
    }

}
