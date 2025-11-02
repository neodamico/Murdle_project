package com.murdle.project.repository;

import com.murdle.project.entity.Casos;
import com.murdle.project.entity.Suspeitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuspeitosRepository extends JpaRepository<Suspeitos,Integer>{
    List<Suspeitos> findByCasos(Casos casos);
}
