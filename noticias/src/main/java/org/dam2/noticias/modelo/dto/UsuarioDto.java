package org.dam2.noticias.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Id;

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
public class UsuarioDto {
	@NonNull
	@EqualsAndHashCode.Include
	private String nickname;
	private int puntos;

}
