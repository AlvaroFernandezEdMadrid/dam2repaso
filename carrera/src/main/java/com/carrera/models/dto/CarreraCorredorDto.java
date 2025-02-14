package com.carrera.models.dto;

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
public class CarreraCorredorDto {
	private int tiempo;
	@EqualsAndHashCode.Include
	private int dorsal;
	@EqualsAndHashCode.Include
	private String corredorDni;
	@EqualsAndHashCode.Include
	private String carreraNombre;
}
