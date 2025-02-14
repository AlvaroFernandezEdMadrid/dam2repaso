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

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class PuntoControl {
	@Id
	@EqualsAndHashCode.Include
	private float kilometro;
	@Column(length = 20)
	private String nombreJuez;
	@ManyToOne (fetch = FetchType.EAGER, optional = true)
	private Corredor primero;
}
