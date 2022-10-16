package com.youtube.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdministradorData implements Serializable {


    @NotEmpty(message="Apelido nao pode ser vazio")
    private String Apelido;
    @NotEmpty(message="Apelido nao pode ser vazio")
    private String Nome;
    @NotEmpty(message="Email nao pode ser vazio")
    @Email(message="insira um email valido")
    private String email;
    @NotEmpty(message="password nao pode ser vazio")
    private String password;
    private Boolean active;

    private String roles;
}
