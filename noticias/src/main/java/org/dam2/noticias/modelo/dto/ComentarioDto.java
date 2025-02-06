package org.dam2.noticias.modelo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class ComentarioDto {
	@NonNull
	@EqualsAndHashCode.Include
	private long id;
	@NonNull
	private String autor;
	@NonNull
	private long noticia;
	private String contenido;
	private int valoracion;
	@NonNull
	private LocalDateTime fecha;
	
}
