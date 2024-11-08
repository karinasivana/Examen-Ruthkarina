package com.demodj.demo_examen.Services.Impl;

import com.demodj.demo_examen.Repositories.EstudiantesRepositories;
import com.demodj.demo_examen.Services.EstudiantesServices;
import com.demodj.demo_examen.models.Estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesServicesImpl implements EstudiantesServices {

    private final EstudiantesRepositories estudiantesRepository;

    @Autowired
    public EstudiantesServicesImpl(EstudiantesRepositories estudiantesRepository) {
        this.estudiantesRepository = estudiantesRepository;
    }

    @Override
    public List<Estudiantes> findAll() {
        return estudiantesRepository.findAll();
    }

    @Override
    public Optional<Estudiantes> findById(Long id) {
        return estudiantesRepository.findById(id);
    }

    @Override
    public Estudiantes save(Estudiantes estudiante) {
        return estudiantesRepository.save(estudiante);
    }

    @Override
    public void deleteById(Long id) {
        estudiantesRepository.deleteById(id);
    }
}

