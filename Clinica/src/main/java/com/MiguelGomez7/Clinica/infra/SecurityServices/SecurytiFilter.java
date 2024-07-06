package com.MiguelGomez7.Clinica.infra.SecurityServices;

import com.MiguelGomez7.Clinica.Repositorys.UsuarioRepositorys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;


import java.io.IOException;

@Component
public class SecurytiFilter extends OncePerRequestFilter {
    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private UsuarioRepositorys usuarioRepository;

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var tokenAutorizado = request.getHeader("Authorization");//asi se debe escribir Authorizadtion, en singular porque si cambias algo aqui se va a generar un error 500
//        if(tokenAutorizado != null ){
//        tokenAutorizado = tokenAutorizado.replace("Bearer", "");
//        System.out.println("El token autorizado que estamos generando es: ["+tokenAutorizado+"]");
//        System.out.println("estamos oteniendo el nombre del usuario o subject: ["+ tokenServices.getSubject(tokenAutorizado));
//
//    }
//        filterChain.doFilter(request,response);
//    }
//}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Obtener el token del header
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = tokenServices.getSubject(token); // extract username
            if (nombreUsuario != null) {
                // Token valido
                var usuario = usuarioRepository.findByLogin(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities()); // Forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}

