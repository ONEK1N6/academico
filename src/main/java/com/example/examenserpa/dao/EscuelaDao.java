package com.example.examenserpa.dao;

import java.util.List;
import java.util.Optional;

import com.example.examenserpa.entity.Escuela;

public interface EscuelaDao {
    Escuela create(Escuela e);
    Escuela update(Escuela e);
    void delete(Long id);
    Optional<Escuela> read(Long id);
    List<Escuela> readAll();
}
