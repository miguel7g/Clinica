//package com.MiguelGomez7.Clinica.Dominio.Consulta.Desafio;
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosCancelamientoConsulta;
//import com.MiguelGomez7.Clinica.Repositorys.ConsultaRepository;
//import jakarta.validation.ValidationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//
//@Component("ValidadorHorarioAntecedenciaCancelamento")
//public class ValidadorHorarioAntecedencia implements ValidadorCancelamientoDeConsulta {
//
//    @Autowired
//    private ConsultaRepository repository;
//
//    @Override
//    public void validar(DatosCancelamientoConsulta datos) {
//        var consulta = repository.getReferenceById(datos.idConsulta());
//        var ahora = LocalDateTime.now();
//        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();
//
//        if (diferenciaEnHoras < 24) {
//            throw new ValidationException("Consulta solamente puede ser cancelada con antecedencia mínima de 24h!");
//        }
//    }
//}