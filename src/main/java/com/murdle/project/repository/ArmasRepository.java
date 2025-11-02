package com.murdle.project.repository;

import com.murdle.project.entity.Armas;
import com.murdle.project.entity.Casos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArmasRepository extends JpaRepository<Armas, Integer>{
    List<Armas> findByCasos(Casos casos);
}
