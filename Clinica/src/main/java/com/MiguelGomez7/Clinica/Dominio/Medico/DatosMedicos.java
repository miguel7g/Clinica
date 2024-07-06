package com.MiguelGomez7.Clinica.Dominio.Medico;

import com.MiguelGomez7.Clinica.Dominio.Direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosMedicos(
        @NotBlank
        String nombre,
        @NotBlank
        String edad,
        @NotBlank
        @Pattern(regexp ="\\d{4,9}" )
        String identidad,
        @NotBlank
        @Email
        String email,
        @NotNull
        String numero_telefono,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DatosDireccion direccion) {

}
