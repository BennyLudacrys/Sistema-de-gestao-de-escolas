package com.youtube.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@Builder
@AllArgsConstructor
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;

    public ImageModel(){}

    public ImageModel(String name, String type, byte[] image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }
}