package com.example.examenserpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenserpa.entity.Facultad;
import com.example.examenserpa.service.FacultadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/facultades")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultadController {

    @Autowired
    private FacultadService service;

    // Método para obtener todas las facultades
    @GetMapping
    public ResponseEntity<List<Facultad>> readAll() {
        try {
            List<Facultad> facultades = service.readAll();
            if (facultades.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(facultades, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear una nueva facultad
    @PostMapping
    public ResponseEntity<Facultad> crear(@Valid @RequestBody Facultad fa) {
        try {
            Facultad f = service.create(fa);
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener una facultad por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Facultad> getFacultadId(@PathVariable("id") Long id) {
        try {
            Optional<Facultad> f = service.read(id);
            if (f.isPresent()) {
                return new ResponseEntity<>(f.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar una facultad por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delFacultad(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar una facultad por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Facultad> updateFacultad(@PathVariable("id") Long id, @Valid @RequestBody Facultad fa) {
        Optional<Facultad> f = service.read(id);
        if (f.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(fa), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}

