package com.carrera.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class CarreraCorredor {
	private int tiempo;
	@Column(length = 10)
	@Id
	@NonNull
	@EqualsAndHashCode.Include
	private String dorsal;
	@ManyToOne(fetch = FetchType.EAGER)
	private Corredor corredor;
	@ManyToOne(fetch = FetchType.EAGER)
	private Carrera carrera;
}
