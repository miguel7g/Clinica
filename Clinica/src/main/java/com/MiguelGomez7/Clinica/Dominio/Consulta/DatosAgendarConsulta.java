//package com.MiguelGomez7.Clinica.Dominio.Consulta;
//
//
//import com.MiguelGomez7.Clinica.Dominio.Medico.Especialidad;
//import jakarta.validation.constraints.Future;
//import jakarta.validation.constraints.NotNull;
//
//
//import java.time.LocalDateTime;
//
//public record DatosAgendarConsulta(
//
//        @NotNull
//        Long idPaciente,
//        Long idMedico,
//        @NotNull
//        @Future
//        LocalDateTime fecha,
//        Especialidad especialidad) {
//
//}