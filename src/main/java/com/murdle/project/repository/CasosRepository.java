package com.murdle.project.repository;

import com.murdle.project.entity.Casos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasosRepository extends JpaRepository<Casos, Integer> {

}
