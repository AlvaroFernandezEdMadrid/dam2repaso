package com.usuarionoticiacomentario.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Usuario {
	@Id
	@Nonnull
	@EqualsAndHashCode.Include
	@Column(length = 10)
	private String nickname;
	@Column(length = 20)
	private String password;
	
	private int puntos;
}
