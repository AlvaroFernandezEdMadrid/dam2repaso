package org.dam2.noticias.servicio;



import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.data.Comentario;
import org.dam2.noticias.modelo.dto.ComentarioDto;



public interface IComentarioServicio {

	public ComentarioDto insertar (ComentarioDto comentarioDto);
	public Optional<ComentarioDto> findById (Long id);
	public List<ComentarioDto> findByNoticia (String titulo);
	public List<ComentarioDto> findAll ();
	//public boolean update (ComentarioDto ComentarioDto);
	public boolean delete (Long id);
	
}
