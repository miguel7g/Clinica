package com.MiguelGomez7.Clinica.Dominio.Medico;

import com.MiguelGomez7.Clinica.Dominio.Direccion.DatosDireccion;

public record DatosRespuestaMedicos(
        Long id,
        String nombre,
        String identidad,
        String edad,
        String email,
        String numero_telefono,
        String especialidad,
        DatosDireccion datosDireccion) {
}
