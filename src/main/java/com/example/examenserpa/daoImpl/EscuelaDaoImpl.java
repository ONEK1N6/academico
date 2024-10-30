package com.example.examenserpa.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenserpa.dao.EscuelaDao;
import com.example.examenserpa.entity.Escuela;
import com.example.examenserpa.repository.EscuelaRepository;

@Component
public class EscuelaDaoImpl implements EscuelaDao {
    @Autowired
    private EscuelaRepository repository;
    
    @Override
    public Escuela create(Escuela e) {
        return repository.save(e);
    }

    @Override
    public Escuela update(Escuela e) {
        return repository.save(e);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Escuela> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Escuela> readAll() {
        return repository.findAll();
    }
}

