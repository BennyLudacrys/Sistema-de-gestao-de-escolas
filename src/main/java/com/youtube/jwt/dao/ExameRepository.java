package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Integer> {
}
