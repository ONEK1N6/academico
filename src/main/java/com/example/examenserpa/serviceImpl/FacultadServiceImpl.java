package com.example.examenserpa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenserpa.entity.Facultad;
import com.example.examenserpa.repository.FacultadRepository;
import com.example.examenserpa.service.FacultadService;

@Service
public class FacultadServiceImpl implements FacultadService {

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

