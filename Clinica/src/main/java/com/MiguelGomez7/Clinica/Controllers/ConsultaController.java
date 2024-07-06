//package com.MiguelGomez7.Clinica.Controllers;
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.AgendaDeConsultaService;
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosAgendarConsulta;
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosCancelamientoConsulta;
//import com.MiguelGomez7.Clinica.Dominio.Consulta.DatosDetalleConsulta;
//import com.MiguelGomez7.Clinica.infra.Errores.ValidacionDeIntegridad;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//
//import jakarta.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@ResponseBody
//@RequestMapping("/consultas")
//@SecurityRequirement(name = "bearer-key")
//@SuppressWarnings("all")
//public class ConsultaController {
//
//    @Autowired
//    private AgendaDeConsultaService service;
//    @GetMapping
//    @Operation(summary = "Obtiene el listado de consultas")
//    public ResponseEntity<Page<DatosDetalleConsulta>> listar(@PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
//        var response = service.consultar(paginacion);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    @Transactional
//    @Operation(
//            summary = "registra una consulta en la base de datos",
//            description = "",
//            tags = { "consulta", "post" })
//    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) throws ValidacionDeIntegridad {
//        var response = service.agendar(datos);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping
//    @Transactional
//    @Operation(
//            summary = "cancela una consulta de la agenda",
//            description = "requiere motivo",
//            tags = { "consulta", "delete" })
//    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta dados) {
//        service.cancelar(dados);
//        return ResponseEntity.noContent().build();
//    }
//}
