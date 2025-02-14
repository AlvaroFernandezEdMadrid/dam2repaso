package com.carrera.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder

@Entity
public class Corredor {
	@Column(length = 20)
	private String nombre;
	@Column(length = 10)
	@Id
	@NonNull
	@EqualsAndHashCode.Include
	private String dni;
	
	private boolean sexo;
}
