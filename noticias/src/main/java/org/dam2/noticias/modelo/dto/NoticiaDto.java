package org.dam2.noticias.modelo.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.dam2.noticias.modelo.data.Categoria;
import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class NoticiaDto {
	@EqualsAndHashCode.Include
	private Long id;
	private String titulo;
	private String cuerpo;
	Categoria categoria;
	private LocalDate fecha;
	private String redactor;
	
}
