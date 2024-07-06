package com.MiguelGomez7.Clinica.Repositorys;

import com.MiguelGomez7.Clinica.Dominio.Medico.Especialidad;
import com.MiguelGomez7.Clinica.Dominio.Medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepositorys extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

//    Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);
//    @Query("""
//            select m.activo
//            from Medico m
//            where m.id=:idMedico
//            """)
//    Boolean findActivoById(Long idMedico);
}

