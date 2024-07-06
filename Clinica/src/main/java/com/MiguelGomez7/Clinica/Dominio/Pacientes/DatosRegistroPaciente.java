//package com.MiguelGomez7.Clinica.Dominio.Pacientes;
//
//import com.MiguelGomez7.Clinica.Dominio.Direccion.DatosDireccion;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//
//
//public record DatosRegistroPaciente(
//        @NotBlank
//        String nombre,
//        @NotBlank
//        String edad,
//        @NotBlank
//        @Email
//        String email,
//
//        @NotBlank
//        @Size(min = 0, max = 15)
//        String numero_telefono,
//
//        //@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
//        @NotBlank
//        String identidad,
//
//        @NotNull @Valid DatosDireccion direccion) {
//}