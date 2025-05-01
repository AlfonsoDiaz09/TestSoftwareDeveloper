package com.example.TestSoftwareDeveloper.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestSoftwareDeveloper.model.Persona;
import com.example.TestSoftwareDeveloper.repository.PersonaRepository;

@Service
public class Directorio {
    private static final Logger logger = LoggerFactory.getLogger(Directorio.class);

    @Autowired
    private PersonaRepository personaRepository;

    public Persona storePersona(Persona persona) {
        logger.info("Guardando persona: {}", persona.getNombre());
        return personaRepository.save(persona);
    }

    public List<Persona> findPersonas() {
        return personaRepository.findAll();
    }

    public Persona findPersonaByIdentificacion(String identificacion) {
        return personaRepository.findPersonaByIdentificacion(identificacion);
    }

    public void deletePersonaByIdentificacion(String identificacion) {
        logger.info("Borrando persona con Identificacion: {}", identificacion);
        personaRepository.deletePersonaByIdentificacion(identificacion);
    }
}