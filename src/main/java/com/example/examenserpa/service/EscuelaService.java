package com.example.examenserpa.service;

import java.util.List;
import java.util.Optional;

import com.example.examenserpa.entity.Escuela;

public interface EscuelaService {
    Escuela create(Escuela e);
    Escuela update(Escuela e);
    void delete(Long id);
    Optional<Escuela> read(Long id);
    List<Escuela> readAll();
}
