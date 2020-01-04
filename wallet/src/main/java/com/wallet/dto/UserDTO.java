package com.wallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * DTO - Data Transfer Object
 * 
 * Permitir que nossas entidadas não sejam manipuladas de fora da nossa API
 */
@Data // Abstração dos Getters e Setters e companhia
public class UserDTO {

  private Long id;

  @Email(message = "Email inválido")
  @NotNull(message = "Email é obrigatório")
  private String email;

  @Length(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
  private String name;

  @NotNull
  @Length(min = 6, message = "Senha deve ter mínimo 6 caracteres")
  private String password;
}