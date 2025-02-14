package com.carrera.models.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder

@Entity
public class Carrera {
	@Id
	@NonNull
	@EqualsAndHashCode.Include
	@Column(length = 20)
	private String nombre;
	private int cupo;
	private LocalDate fecha;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Singular
	private Set<PuntoControl> puntos;
}
