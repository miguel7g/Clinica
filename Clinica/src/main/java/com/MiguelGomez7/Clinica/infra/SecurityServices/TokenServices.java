package com.MiguelGomez7.Clinica.infra.SecurityServices;

import com.MiguelGomez7.Clinica.Dominio.Usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class TokenServices{
//    @Value("${api.security.secret}")// esta anotacion es de Spring no de lombock
//    private String apiSecret;
    @Value("${api.security.secret}")// esta anotacion es de Spring no de lombock
    private String apiSecret;
    public TokenServices() {
        System.out.println("apiSecret: " + apiSecret);
    }
    public String generateTokens(Usuario usuario){
       try{
           Algorithm algorithm = Algorithm.HMAC256(apiSecret);
           System.out.println("apiSecret: " + apiSecret);
           return JWT.create()
                   .withIssuer("Cliniapi")// este es el que emite,es el nombre  de tu aplicacion
                   .withSubject(usuario.getLogin())
                   .withClaim("id", usuario.getId())
                   .withExpiresAt(generarFechaDeVencimiento())
                   .sign(algorithm);
       }catch(JWTCreationException exception){
           throw new RuntimeException();

        }

    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma
       System.out.println("apiSecret: " + apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("Cliniapi")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verifier invalido");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaDeVencimiento() {
        return LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.of("-04:30"));
    }
}

