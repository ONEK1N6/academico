package com.example.examenserpa.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.examenserpa.dao.FacultadDao;
import com.example.examenserpa.entity.Facultad;
import com.example.examenserpa.repository.FacultadRepository;

@Component
public class FacultadDaoImpl implements FacultadDao {
    @Autowired
    private FacultadRepository repository;
    
    @Override
    public Facultad create(Facultad f) {
        return repository.save(f);
    }

    @Override
    public Facultad update(Facultad f) {
        return repository.save(f);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Facultad> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Facultad> readAll() {
        return repository.findAll();
    }
}

