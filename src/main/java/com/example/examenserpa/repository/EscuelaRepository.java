package com.example.examenserpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenserpa.entity.Escuela;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long> {
}

