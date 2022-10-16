package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {
}
