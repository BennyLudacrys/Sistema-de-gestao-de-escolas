package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Avaliacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Integer> {
}
