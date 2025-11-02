package com.murdle.project.repository;

import com.murdle.project.entity.Casos;
import com.murdle.project.entity.Locais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocaisRepository extends JpaRepository<Locais, Integer>{
    List<Locais> findByCasos(Casos casos);
}
