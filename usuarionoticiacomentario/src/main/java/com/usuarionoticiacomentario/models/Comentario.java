package com.usuarionoticiacomentario.models;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
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
public class Comentario {
	@Id
	@NonNull
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario autor;
	@ManyToOne(fetch = FetchType.EAGER)
	private Noticia noticia;
	
	private LocalDate fecha;
	
	private String contenido;
	
	private int valoracion;
}
