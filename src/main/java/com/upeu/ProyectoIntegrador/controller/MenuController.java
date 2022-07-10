package com.upeu.ProyectoIntegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/menu")
    public String home(Model model){
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "dashboard/dashboard";
    }

    @GetMapping("/persona")
    public String indexPersona(Model model) {
        model.addAttribute("mensaje", "Personas");
        return "personas/personas";
    }

    @GetMapping("/programa")
    public String indexPrograma(Model model) {
        model.addAttribute("mensaje", "Programas");
        return "programas/programa";
    }

    @GetMapping("/taller")
    public String indexTaller(Model model) {
        model.addAttribute("mensaje", "Talleres");
        return "talleres/talleres";
    }

    @GetMapping("/tipo-persona")
    public String indexTipoPersona(Model model) {
        model.addAttribute("mensaje", "Tipos Persona");
        return "tipoPersona/tipoPersona";
    }
    
    @GetMapping("/persona-taller")
    public String indexPersonaTaller(Model model){
        model.addAttribute("mensaje", "Enlace de persona y taller");
        return "personaTaller/personaTaller";
    }
}
