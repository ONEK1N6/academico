package com.example.examenserpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenserpa.entity.Facultad;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long> {
}

