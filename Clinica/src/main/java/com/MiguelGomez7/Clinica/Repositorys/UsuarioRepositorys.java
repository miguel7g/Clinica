package com.MiguelGomez7.Clinica.Repositorys;

import com.MiguelGomez7.Clinica.Dominio.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorys extends JpaRepository<Usuario, Long>{
    UserDetails findByLogin(String username);

}
