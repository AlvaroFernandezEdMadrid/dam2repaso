package org.dam2.examencarrera.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;


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

@Entity
@EntityListeners(CorredorListener.class)
public class Corredor implements Serializable {
	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	private String dni;
	private String nombre;
	private boolean sexo;
	

}
