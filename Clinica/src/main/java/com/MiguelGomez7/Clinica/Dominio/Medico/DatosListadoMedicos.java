package com.MiguelGomez7.Clinica.Dominio.Medico;

public record DatosListadoMedicos(
        Long id,
        String nombre,
        String email,
        String  identidad,
        String  numero_telefono,
        String especialidad) {

    public DatosListadoMedicos(Medico medico){
        this(medico.getId(), medico.getNombre(),medico.getEmail(),medico.getIdentidad(),medico.getNumero_telefono(), medico.getEspecialidad().toString());
    }
}
