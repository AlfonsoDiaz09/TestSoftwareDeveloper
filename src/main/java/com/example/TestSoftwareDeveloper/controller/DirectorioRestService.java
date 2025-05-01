package com.example.TestSoftwareDeveloper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.TestSoftwareDeveloper.model.Persona;
import com.example.TestSoftwareDeveloper.service.Directorio;

@RestController
@RequestMapping("/directorio")
public class DirectorioRestService {

    @Autowired
    private Directorio directorio;

    @PostMapping("/storePersona")
    public ResponseEntity<Persona> crearPersona(@RequestBody @Validated Persona persona) {
        return ResponseEntity.ok(directorio.storePersona(persona));
    }

    @DeleteMapping("/deletePersona/{identificacion}")
    public ResponseEntity<Void> borrarPersonaPorIdentificacion(@PathVariable String identificacion) {
        directorio.deletePersonaByIdentificacion(identificacion);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findPersonas")
    public ResponseEntity<List<Persona>> buscarPersonas() {
        return ResponseEntity.ok(directorio.findPersonas());
    }

    @GetMapping("/findPersonaByIdentificacion/{identificacion}")
    public ResponseEntity<Persona> buscarPersonaPorIdentificacion(@PathVariable String identificacion) {
        return ResponseEntity.ok(directorio.findPersonaByIdentificacion(identificacion));
    }
}