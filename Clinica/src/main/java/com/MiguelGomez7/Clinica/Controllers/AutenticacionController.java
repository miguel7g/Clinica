package com.MiguelGomez7.Clinica.Controllers;

import com.MiguelGomez7.Clinica.Dominio.Usuarios.DatosDeAutenticacionUsuarios;
import com.MiguelGomez7.Clinica.Dominio.Usuarios.Usuario;
import com.MiguelGomez7.Clinica.infra.SecurityServices.TokenServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
//para disparar el proceso de autenticacion en spring de, existe una clase llamada authenticationManager y se declara asi:
@Autowired//esto para inyectar las dependencias
    private AuthenticationManager authenticationManager;
@Autowired
private TokenServices tokenServices;
@PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosDeAutenticacionUsuarios datosDeAutenticacionUsuarios){
    Authentication AutemticationsToken = new UsernamePasswordAuthenticationToken(datosDeAutenticacionUsuarios.login(),
            datosDeAutenticacionUsuarios.clave());
     var usuarioAutenticado = authenticationManager.authenticate(AutemticationsToken );
    var JWTToken = tokenServices.generateTokens((Usuario) usuarioAutenticado.getPrincipal());
    return ResponseEntity.ok(JWTToken);
    }
}
