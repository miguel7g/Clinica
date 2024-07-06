//package com.MiguelGomez7.Clinica.Dominio.Consulta.Validaciones;
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosAgendarConsulta;
//import com.MiguelGomez7.Clinica.Repositorys.PacienteRepository;
//import jakarta.validation.ValidationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PacienteActivo implements ValidadorDeConsultas{
//    @Autowired
//    private PacienteRepository repository;
//
//    public void validar(DatosAgendarConsulta datos){
//        if(datos.idPaciente()==null){
//            return;
//        }
//        var pacienteActivo=repository.findActivoById(datos.idPaciente());
//
//        if(!pacienteActivo){
//            throw new ValidationException("No se puede permitir agendar citas con pacientes inactivos en el sistema");
//        }
//    }
//}