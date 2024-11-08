package com.demodj.demo_examen.Repositories;

import com.demodj.demo_examen.models.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepositories extends JpaRepository<Estudiantes, Long> {
}
