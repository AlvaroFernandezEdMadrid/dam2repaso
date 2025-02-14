package org.dam2.examencarrera.modelo.entidad;

import java.io.Serializable;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity

public class PuntoControl implements Serializable {

	@NonNull
	@EqualsAndHashCode.Include
	@Id
	private Float pk;
	@Column(unique = true)
	private String juez;
	
	@ManyToOne (fetch = FetchType.EAGER,optional = true)
	private Corredor primero;
	
	private int tiempo;

}
