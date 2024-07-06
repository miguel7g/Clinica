package com.MiguelGomez7.Clinica.Dominio.Direccion;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank
        String pais,
        @NotBlank
        String estado,
        @NotBlank
        String ciudad,
        @NotBlank
        String calle,
        @NotBlank
        String tipo_vivienda,
        @NotBlank
        String numero_vivienda) {
}
