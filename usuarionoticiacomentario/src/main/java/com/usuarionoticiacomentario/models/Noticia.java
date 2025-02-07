package com.usuarionoticiacomentario.models;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder


@Entity
public class Noticia {
	@Id
	@NonNull
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(length = 40)
	private String titulo;
	private String cuerpo;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private LocalDate fecha;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario redactor;
}
