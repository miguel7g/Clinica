//package com.MiguelGomez7.Clinica.Dominio.Consulta.Validaciones;
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosAgendarConsulta;
//import com.MiguelGomez7.Clinica.Repositorys.MedicoRepositorys;
//import jakarta.validation.ValidationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MedicoActivo implements ValidadorDeConsultas{
//    @Autowired
//    private MedicoRepositorys repository;
//
//    public void validar(DatosAgendarConsulta datos) {
//        if(datos.idMedico()==null){
//            return;
//        }
//        var medicoActivo=repository.findActivoById(datos.idMedico());
//        if(!medicoActivo){
//            throw new ValidationException("No se puede permitir agendar citas con medicos inactivos en el sistema");
//        }
//    }
//}