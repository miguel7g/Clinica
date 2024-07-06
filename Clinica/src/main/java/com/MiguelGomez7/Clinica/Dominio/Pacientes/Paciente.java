//package com.MiguelGomez7.Clinica.Dominio.Pacientes;
//
//import com.MiguelGomez7.Clinica.Dominio.Direccion.Direccion;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//
//
//@Table(name = "pacientes")
//@Entity(name = "Paciente")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Paciente {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nombre;
//    private String edad;
//    private String email;
//    private String numero_telefono;
//    private String identidad;
//
//    @Embedded
//    private Direccion direccion;
//
//    private Boolean activo;
//
//    public Paciente(DatosRegistroPaciente datos) {
//        this.activo = true;
//        this.nombre = datos.nombre();
//        this.edad = datos.edad();
//        this.email = datos.email();
//        this.numero_telefono = datos.numero_telefono();
//        this.identidad = datos.identidad();
//        this.direccion = new Direccion(datos.direccion());
//    }
//
//    public void actualizarInformacoes(DatosActualizacionPaciente datos) {
//        if (datos.nombre() != null) {
//            this.nombre = datos.nombre();
//        }
//        if (datos.numero_telefono() != null) {
//            this.numero_telefono = datos.numero_telefono();
//        }
//        if (datos.direccion() != null) {
//            this.direccion.actualizarDatos(datos.direccion());
//        }
//
//    }
//
//    public void eliminar() {
//        this.activo = false;
//    }
//}