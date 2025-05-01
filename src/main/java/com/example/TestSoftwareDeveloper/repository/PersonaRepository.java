package com.example.TestSoftwareDeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.TestSoftwareDeveloper.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findPersonaByIdentificacion(String identificacion);
    @Transactional
    void deletePersonaByIdentificacion(String identificacion);
}