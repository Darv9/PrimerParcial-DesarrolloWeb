/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.controller;

import com.ITicket.entity.Artista;
import com.ITicket.entity.Concierto;
import com.ITicket.service.IArtistaService;
import com.ITicket.service.IConciertoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author danie
 */
@Controller
public class ConciertoController {
    
    @Autowired
    private IArtistaService artistaService;
            
    @Autowired
    private IConciertoService conciertoService;
    
    @GetMapping("/conciertos")
    public String index(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("titulo", "Tabla Conciertos");
        model.addAttribute("conciertos", listaConcierto);
        return "conciertos";
    }
    
    @GetMapping("/conciertosN")
    public String agregarVerdura (Model model){
        List<Artista> listaArtistas = artistaService.listArtist();
        model.addAttribute("concierto",new Concierto());
        model.addAttribute("artistas",listaArtistas);
        return "crear";
    }
    
    @GetMapping("/editconciertos/{id}")
    public String editarVerdura(@PathVariable("id") Long idConcierto, Model model) {
        Concierto conciertos = conciertoService.getConciertoById(idConcierto);
        List<Artista> listaArtistas = artistaService.listArtist();
        model.addAttribute("concierto", conciertos);
        model.addAttribute("artistas", listaArtistas);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long idConcierto) {
        conciertoService.delete(idConcierto);
        return "redirect:/conciertos";
    }

    @PostMapping("/save")
    public String guardarVerdura(@ModelAttribute Concierto concierto) {
        conciertoService.saveConcierto(concierto);
        return "redirect:/conciertos";
    }
}
