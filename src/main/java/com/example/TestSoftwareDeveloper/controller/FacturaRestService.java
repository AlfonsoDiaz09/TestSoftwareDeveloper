package com.example.TestSoftwareDeveloper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.TestSoftwareDeveloper.model.Factura;
import com.example.TestSoftwareDeveloper.service.Ventas;

@RestController
@RequestMapping("/factura")
public class FacturaRestService {

    @Autowired
    private Ventas ventas;

    @PostMapping("/storeFactura")
    public ResponseEntity<Factura> crearFactura(@RequestBody @Validated Factura factura) {
        return ResponseEntity.ok(ventas.storeFactura(factura));
    }

    @GetMapping("/findFacturasByPersona/{identificacion}")
    public ResponseEntity<List<Factura>> buscarFacturasPorPersona(@PathVariable String identificacion) {
        return ResponseEntity.ok(ventas.findFacturasByPersona(identificacion));
    }
}