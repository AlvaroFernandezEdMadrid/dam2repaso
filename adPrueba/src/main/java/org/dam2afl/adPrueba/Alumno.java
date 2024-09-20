package org.dam2afl.adPrueba;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true) 
@Builder
public class Alumno {
	@EqualsAndHashCode.Include
	@NonNull
	private String dni;

	private String nombre;
	private int edad;


}
