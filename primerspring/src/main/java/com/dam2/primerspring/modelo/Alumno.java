package com.dam2.primerspring.modelo;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Alumno {
	@Id
	@EqualsAndHashCode.Include
	private String nia;
	
	private String nombre;
	
	private int nota;
	
	private LocalDate fecha;
}
