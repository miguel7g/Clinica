package com.MiguelGomez7.Clinica.Dominio.Medico;

import com.MiguelGomez7.Clinica.Dominio.Direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatoActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String identidad,
        DatosDireccion direccion) {
}
