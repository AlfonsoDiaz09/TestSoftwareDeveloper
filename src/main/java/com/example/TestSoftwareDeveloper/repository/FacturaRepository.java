package com.example.TestSoftwareDeveloper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TestSoftwareDeveloper.model.Factura;
import com.example.TestSoftwareDeveloper.model.Persona;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findFacturasByPersona(Persona persona);
}