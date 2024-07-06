//package com.MiguelGomez7.Clinica.Dominio.Pacientes;
//
//
//import com.MiguelGomez7.Clinica.Dominio.Direccion.Direccion;
//
//public record DatosDetallePaciente(Long id, String nombre,String edad, String email, String identidad, String numero_telefono, Direccion direccion) {
//
//    public DatosDetallePaciente(Paciente paciente) {
//        this(paciente.getId(), paciente.getNombre(), paciente.getEdad(),paciente.getEmail(), paciente.getIdentidad(), paciente.getNumero_telefono(), paciente.getDireccion());
//    }
//}