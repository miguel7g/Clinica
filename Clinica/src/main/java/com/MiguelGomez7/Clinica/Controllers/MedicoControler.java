package com.MiguelGomez7.Clinica.Controllers;

import com.MiguelGomez7.Clinica.Dominio.Direccion.DatosDireccion;
import com.MiguelGomez7.Clinica.Dominio.Medico.*;
import com.MiguelGomez7.Clinica.Repositorys.MedicoRepositorys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoControler {

    //crear un metodo
    @Autowired//esta anotacion llama a la clase medicorepository, y hereda todas las caracteristicas de jparepository
    private MedicoRepositorys medicoRepositorys;
    @PostMapping()
    public ResponseEntity<DatosRespuestaMedicos> RegistrarMedico(@RequestBody @Valid DatosMedicos datosMedicos, UriComponentsBuilder uriComponentsBuilder){/*el metodo post deberia retornar una url que
     permita accder al objeto que estamos creando este metodo se llama helper que es directo de spring que nos permite crear uri*/
        Medico medico = medicoRepositorys.save(new Medico(datosMedicos));
        //creamos un metodo que depende de la dto DatosRespuestaMedico
        DatosRespuestaMedicos datosRespuestaMedicos = new DatosRespuestaMedicos(medico.getId(),medico.getNombre(),medico.getIdentidad(),medico.getEdad(),medico.getEmail(),
                medico.getNumero_telefono(),medico.getEspecialidad().toString(),new DatosDireccion(medico.getDireccion().getPais(), medico.getDireccion().getEstado(),
                medico.getDireccion().getCiudad(),medico.getDireccion().getCalle(),medico.getDireccion().getTipo_vivienda(),medico.getDireccion().getNumero_vivienda()));
       URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMedicos);
    }

//creamos una lista de medicos para saber cuantos medicos tenemos registrados y sus especialidades
    @GetMapping
    public ResponseEntity<Page<DatosListadoMedicos>> listaDeMedicos(Pageable paginacion){//listaDeMedicos(@PageableDefault(size = 10) Pageable paginacion), usando la anotacion @PageableDefault puedes modificar cualquier parametro que viene por defecto en este caso el tamaño usando size
       // return medicoRepositorys.findAll(paginacion).map(DatosListadoMedicos::new);

        return ResponseEntity.ok(medicoRepositorys.findByActivoTrue(paginacion).map(DatosListadoMedicos::new));
    }

    /*Creamos un bunevo metodo get que nos va a entregar respuetas a trabes de uns URI especifica de un objeto creado */
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedicos> retornaDatosMedicos (@PathVariable Long id){
        Medico medico = medicoRepositorys.getReferenceById(id);
        var datosRespuestaMedico = new DatosRespuestaMedicos(medico.getId(),medico.getNombre(),medico.getIdentidad(),medico.getEdad(),medico.getEmail(),
                medico.getNumero_telefono(),medico.getEspecialidad().toString(),new DatosDireccion(medico.getDireccion().getPais(), medico.getDireccion().getEstado(),
                medico.getDireccion().getCiudad(),medico.getDireccion().getCalle(),medico.getDireccion().getTipo_vivienda(),medico.getDireccion().getNumero_vivienda()));

        return ResponseEntity.ok(datosRespuestaMedico);
    }

    //se van usar querys params, que son parametros que van separados por signos de interrogacion en la url

    //se crea un metodo para actualizar datos medicos
    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedicos(@RequestBody @Valid DatoActualizarMedico datoActualizarMedico){
        Medico medico = medicoRepositorys.getReferenceById(datoActualizarMedico.id());
        medico.actualizarDatos(datoActualizarMedico);
        //para estar a seguro se coloca como parametro mi clase dto o record datos medicos
        return ResponseEntity.ok(new DatosRespuestaMedicos( medico.getId(),medico.getNombre(),medico.getIdentidad(),medico.getEdad(),medico.getEmail(),
                medico.getNumero_telefono(),medico.getEspecialidad().toString(),new DatosDireccion(medico.getDireccion().getPais(), medico.getDireccion().getEstado(),
                medico.getDireccion().getCiudad(),medico.getDireccion().getCalle(),medico.getDireccion().getTipo_vivienda(),medico.getDireccion().getNumero_vivienda())));
    }

    //creamos un metodo para elminar medicos logico o parcial
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedicoLogico(@PathVariable Long id){
        Medico medico = medicoRepositorys.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
        //con esta accion de ResponseEntity, debemos retornar una condicion de responseEntity, aplicar el metodo o las acciones
        //en este caso .noContent(). build(); se usa el build porque el nocontent es un metodo estatico y no va acompliar
    }

    //creamos un metodo para elminar medicos definitivo
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void eliminarMedicoDefinitivo(@PathVariable Long id){
//        Medico medico = medicoRepositorys.getReferenceById(id);
//        medicoRepositorys.delete(medico);
//    }


}
