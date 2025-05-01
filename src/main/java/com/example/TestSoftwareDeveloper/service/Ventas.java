package com.example.TestSoftwareDeveloper.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestSoftwareDeveloper.model.Factura;
import com.example.TestSoftwareDeveloper.model.Persona;
import com.example.TestSoftwareDeveloper.repository.FacturaRepository;
import com.example.TestSoftwareDeveloper.repository.PersonaRepository;

@Service
public class Ventas {
    private static final Logger logger = LoggerFactory.getLogger(Ventas.class);

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public Factura storeFactura(Factura factura) {
        Persona personaCompleta = personaRepository.findById(factura.getPersona().getId()).orElse(null);
        factura.setPersona(personaCompleta);
        logger.info("Guardando factura de: {}", personaCompleta.getNombre().toString());
        
        return facturaRepository.save(factura);
    }

    public List<Factura> findFacturasByPersona(String identificacion) {
        Persona persona = personaRepository.findPersonaByIdentificacion(identificacion);
        return facturaRepository.findFacturasByPersona(persona);
    }
}