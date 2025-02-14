package com.carrera.models.dto;

import java.time.LocalDate;
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
public class CarreraDto {
	@EqualsAndHashCode.Include
	@NonNull
	private String nombre;
	private int cupo;
	private LocalDate fecha;
}
