//package com.MiguelGomez7.Clinica.Repositorys;
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.Consulta;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//
//@Repository
//public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
//
//    Boolean existsByPacienteIdAndFechaBetween(Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);
//
//    Boolean existsByMedicoIdAndFecha(Long idMedico, LocalDateTime fecha);
//}