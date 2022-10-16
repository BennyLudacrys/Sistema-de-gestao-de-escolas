package com.youtube.jwt.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Planificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_planificacao;
    private String Descricao;
    private LocalDate Data_inicio;
    private LocalDate Data_fim;
}
