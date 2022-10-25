package com.youtube.jwt.dao;

import com.youtube.jwt.entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}
