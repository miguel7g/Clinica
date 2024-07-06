package com.MiguelGomez7.Clinica.Dominio.Direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Embeddable
//anotaciones que evitan hacer reperticiones gracias a lombock
@Getter//aqui lombok crea getters automaticamente
@AllArgsConstructor// esta anotacon de lombok crrea constructores llenos
@NoArgsConstructor// en este caso se crea in constructor vacio gracia a lombok
public class Direccion {
    private String pais;
    private String estado;
    private String ciudad;
    private String calle;
    private String tipo_vivienda;
    private String numero_vivienda;


    public Direccion(DatosDireccion direccion) {
        this.pais = direccion.pais();
        this.estado = direccion.estado();
        this.ciudad = direccion.ciudad();
        this.calle = direccion.calle();
        this.tipo_vivienda = direccion.tipo_vivienda();
        this.numero_vivienda = direccion.numero_vivienda();

    }

    //se crea constructor actualizarDatos
    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.pais = direccion.pais();
        this.estado = direccion.estado();
        this.ciudad = direccion.ciudad();
        this.calle = direccion.calle();
        this.tipo_vivienda = direccion.tipo_vivienda();
        this.numero_vivienda = direccion.numero_vivienda();
        return this;
    }

}
