package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Planificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanificacaoRepository extends JpaRepository<Planificacao, Integer> {
}
