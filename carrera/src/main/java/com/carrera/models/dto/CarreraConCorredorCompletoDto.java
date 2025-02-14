package com.carrera.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class CarreraConCorredorCompletoDto {
	@NonNull
	@EqualsAndHashCode.Include
	private CorredorDto corredor;
	
	@NonNull
	@EqualsAndHashCode.Include
	private String carreraNombre;
	
	private int tiempo;
	private int dorsal;

}
