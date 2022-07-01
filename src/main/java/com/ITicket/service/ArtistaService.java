/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.Artista;
import com.ITicket.repository.ArtistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class ArtistaService implements IArtistaService{
    
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> listArtist() {
        return (List<Artista>)artistaRepository.findAll();
    }
    
}
