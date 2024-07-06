package com.MiguelGomez7.Clinica.infra.SecurityServices;

import com.MiguelGomez7.Clinica.Repositorys.UsuarioRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service//con esta anotacion le decimos a jpa que escanee entre sus funciones para que sepa que esto es un sercvicio de la aplicacion
public class AutenticacionServices implements UserDetailsService {
    @Autowired
    private UsuarioRepositorys usuarioRepositorys;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepositorys.findByLogin(username);
    }
}
