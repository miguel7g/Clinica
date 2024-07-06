package com.MiguelGomez7.Clinica.Dominio.Usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")

//anotaciones que evitan hacer reperticiones gracias a lombock
@Getter//aqui lombok crea getters automaticamente
@AllArgsConstructor// esta anotacon de lombok crrea constructores llenos
@NoArgsConstructor// en este caso se crea in constructor vacio gracia a lombok
@EqualsAndHashCode(of = "id")//esto es como si reescribirea en metodo hashCode pero lombo lo hace automaticamente

public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String clave;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {//si indica que se debe generar el rol que va a tener el usuario dentro de la aplicacion, si este no tiene este roll de usuaio sprin va a bloquear el acceso por el hecho de no tener un rol
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));// se retorna una lista de roles la cual se denomina roll_users, esta lista va a hacer que todos los usuarios que ingresenten tendran por defecto el rol de usuarios
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
