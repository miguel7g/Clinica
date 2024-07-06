//package com.MiguelGomez7.Clinica.Dominio.Consulta.Validaciones;
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosAgendarConsulta;
//import jakarta.validation.ValidationException;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//
//@Component
//public class HorarioDeAnticipacion implements ValidadorDeConsultas{
//    public void validar(DatosAgendarConsulta datos) {
//        var ahora = LocalDateTime.now();
//        var horaDeConsulta= datos.fecha();
//
//        var diferenciaDe30Min= Duration.between(ahora,horaDeConsulta).toMinutes()<30;
//        if(diferenciaDe30Min){
//            throw new ValidationException("Las consultas deben programarse con al menos 30 minutos de anticipación");
//        }
//    }
//}