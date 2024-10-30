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

import com.example.examenserpa.entity.Escuela;
import com.example.examenserpa.service.EscuelaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/escuelas")
@CrossOrigin(origins = "http://localhost:4200")
public class EscuelaController {

    @Autowired
    private EscuelaService service;

    // Método para obtener todas las escuelas
    @GetMapping
    public ResponseEntity<List<Escuela>> readAll() {
        try {
            List<Escuela> escuelas = service.readAll();
            if (escuelas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(escuelas, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear una nueva escuela
    @PostMapping
    public ResponseEntity<Escuela> crear(@Valid @RequestBody Escuela es) {
        try {
            Escuela e = service.create(es);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener una escuela por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuelaId(@PathVariable("id") Long id) {
        try {
            Optional<Escuela> e = service.read(id);
            if (e.isPresent()) {
                return new ResponseEntity<>(e.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar una escuela por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delEscuela(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar una escuela por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Escuela> updateEscuela(@PathVariable("id") Long id, @Valid @RequestBody Escuela es) {
        Optional<Escuela> e = service.read(id);
        if (e.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(service.update(es), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
