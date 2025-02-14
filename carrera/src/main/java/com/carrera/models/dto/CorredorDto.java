package com.carrera.models.dto;

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
public class CorredorDto {
	private String nombre;
	@EqualsAndHashCode.Include
	@NonNull
	private String dni;
	private boolean sexo;
}
