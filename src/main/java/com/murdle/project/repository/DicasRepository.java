package com.murdle.project.repository;

import com.murdle.project.entity.Casos;
import com.murdle.project.entity.Dicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DicasRepository extends JpaRepository<Dicas, Integer> {
    List<Dicas> findByCasos(Casos casos);
}
