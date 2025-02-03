package com.pruebacontrolador.model;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo")
public class Material {
	@Id
	@EqualsAndHashCode.Include
	@NonNull
	@Column(length = 8)
	private String referencia;
	@Column(length = 20)
	private String nombre;
	@Column(length = 30)
	private String director;
	
	private LocalDate fechaEstreno;
	@Enumerated(EnumType.STRING)
	
	public boolean isEstrenado() {
		return fechaEstreno.isBefore(LocalDate.now());
	}
}

