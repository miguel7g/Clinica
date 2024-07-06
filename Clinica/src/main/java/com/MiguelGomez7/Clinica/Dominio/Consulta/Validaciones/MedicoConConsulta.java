//package com.MiguelGomez7.Clinica.Dominio.Consulta.Validaciones;
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosAgendarConsulta;
//import com.MiguelGomez7.Clinica.Repositorys.ConsultaRepository;
//import jakarta.validation.ValidationException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MedicoConConsulta implements  ValidadorDeConsultas{
//    @Autowired
//    private ConsultaRepository repository;
//
//    public void validar(DatosAgendarConsulta datos) {
//        if(datos.idMedico()==null)
//            return;
//
//        var medicoConConsulta= repository.existsByMedicoIdAndFecha(datos.idMedico(),datos.fecha());
//        if(medicoConConsulta){
//            throw new ValidationException("este medico ya tiene una consulta en ese horario");
//        }
//    }
//}