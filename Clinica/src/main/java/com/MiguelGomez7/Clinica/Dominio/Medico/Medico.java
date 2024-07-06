package com.MiguelGomez7.Clinica.Dominio.Medico;

import com.MiguelGomez7.Clinica.Dominio.Direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")

//anotaciones que evitan hacer reperticiones gracias a lombock
@Getter//aqui lombok crea getters automaticamente
@AllArgsConstructor// esta anotacon de lombok crrea constructores llenos
@NoArgsConstructor// en este caso se crea in constructor vacio gracia a lombok
@EqualsAndHashCode(of = "id")//esto es como si reescribirea en metodo hashCode pero lombo lo hace automaticamente
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String edad;
    private String identidad;
    private String email;
    private boolean activo;
    private String numero_telefono;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded //La anotación @Embedded en JPA se utiliza para incrustar un tipo dentro de otra entidad. Esta característica permite agrupar varios campos relacionados en una sola clase, que luego se puede incrustar en otras entidades.
    private Direccion direccion;

    public Medico(DatosMedicos datosMedicos) {
        this.activo = true;
        this.nombre= datosMedicos.nombre();
        this.edad= datosMedicos.edad();
        this.email = datosMedicos.email();
        this.identidad = datosMedicos.identidad();
        this.numero_telefono = datosMedicos.numero_telefono();
        this.especialidad = datosMedicos.especialidad();
        this.direccion = new Direccion(datosMedicos.direccion());
    }

    //se crea un cnstructo para la clase dto actualizaMedico
    public void actualizarDatos(DatoActualizarMedico datoActualizarMedico){
        //agregamos un condicional por si no se desea actualizzar algun campo, este no retorne un dato nulo o null
        //el condicional permitebque si este campo no  se cumple no existe la accion
        if (datoActualizarMedico.nombre() != null) {
            this.nombre= datoActualizarMedico.nombre();
        }

        if (datoActualizarMedico.identidad() != null) {
            this.identidad = datoActualizarMedico.identidad();
        }

        if (datoActualizarMedico.direccion() != null) {
            this.direccion = direccion.actualizarDatos(datoActualizarMedico.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
