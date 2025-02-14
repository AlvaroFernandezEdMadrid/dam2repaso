package com.carrera.models.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class CarreraConPCDto {
	@NonNull
	@EqualsAndHashCode.Include
	private String nombre;
	private int tope;
	private LocalDate fecha;
	
	@Singular
	private Set<PuntoControlDto> puntos;

}
