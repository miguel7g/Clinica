//package com.MiguelGomez7.Clinica.Dominio.Consulta;
//
//
//import com.MiguelGomez7.Clinica.Dominio.Consulta.Desafio.ValidadorCancelamientoDeConsulta;
//import com.MiguelGomez7.Clinica.Dominio.Consulta.Validaciones.ValidadorDeConsultas;
//import com.MiguelGomez7.Clinica.Dominio.Medico.Medico;
//import com.MiguelGomez7.Clinica.Repositorys.ConsultaRepository;
//import com.MiguelGomez7.Clinica.Repositorys.MedicoRepositorys;
//import com.MiguelGomez7.Clinica.Repositorys.PacienteRepository;
//import com.MiguelGomez7.Clinica.infra.Errores.ValidacionDeIntegridad;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@SuppressWarnings("all")
//public class AgendaDeConsultaService {
//    @Autowired
//    private PacienteRepository pacienteRepository;
//    @Autowired
//    private MedicoRepositorys medicoRepository;
//    @Autowired
//    private ConsultaRepository consultaRepository;
//
//    @Autowired
//    List<ValidadorDeConsultas> validadores;
//
//    @Autowired
//    private List<ValidadorCancelamientoDeConsulta> validadoresCancelamiento;
//
//    public DatosDetalleConsulta agendar(DatosAgendarConsulta datos){
//
//        if(!pacienteRepository.findById(datos.idPaciente()).isPresent()){
//            throw new ValidacionDeIntegridad("este id para el paciente no fue encontrado");
//        }
//
//        if(datos.idMedico()!=null && !medicoRepository.existsById(datos.idMedico())){
//            throw new ValidacionDeIntegridad("este id para el medico no fue encontrado");
//        }
//
//        validadores.forEach(v-> v.validar(datos));
//
//        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
//
//        var medico = seleccionarMedico(datos);
//
//        if(medico==null){
//            throw new ValidacionDeIntegridad("no existen medicos disponibles para este horario y especialidad");
//        }
//
//        var consulta = new Consulta(medico,paciente,datos.fecha());
//
//        consultaRepository.save(consulta);
//
//        return new DatosDetalleConsulta(consulta);
//
//    }
//
//    public void cancelar(DatosCancelamientoConsulta datos) {
//        if (!consultaRepository.existsById(datos.idConsulta())) {
//            throw new ValidacionDeIntegridad("Id de la consulta informado no existe!");
//        }
//
//        validadoresCancelamiento.forEach(v -> v.validar(datos));
//
//        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
//        consulta.cancelar(datos.motivo());
//    }
//
//    private Medico seleccionarMedico(DatosAgendarConsulta datos) {
//        if(datos.idMedico()!=null){
//            return medicoRepository.getReferenceById(datos.idMedico());
//        }
//        if(datos.especialidad()==null){
//            throw new ValidacionDeIntegridad("debe seleccionarse una especialidad para el medico");
//        }
//        return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(datos.especialidad(),datos.fecha());
//    }
//
//    public Page<DatosDetalleConsulta> consultar(Pageable paginacion) {
//        return consultaRepository.findAll(paginacion).map(DatosDetalleConsulta::new);
//    }
//}