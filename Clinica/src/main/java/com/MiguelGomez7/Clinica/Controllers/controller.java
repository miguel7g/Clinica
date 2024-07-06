package com.MiguelGomez7.Clinica.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/Saludo")
public class controller {
    @GetMapping
    public String HolaChiva7(){
        return "Les saluda 👋 La chiva 🐐 desde La sala viendo ⚽ Inglaterra & Dinamarca ⚽";
    }
}
