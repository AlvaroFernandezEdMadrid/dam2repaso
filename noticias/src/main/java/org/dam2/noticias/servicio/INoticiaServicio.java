package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.data.Categoria;
import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.dto.NoticiaDto;



public interface INoticiaServicio {
	public NoticiaDto insertar (NoticiaDto noticia);
	public Optional<NoticiaDto> findById (Long id);
	public List<NoticiaDto> findByTitulo (String titulo);
	public List<NoticiaDto> findAll ();
	//public boolean update (NoticiaDto noticia);
	public boolean delete (Long id);
	public int deleteByTitulo (String titulo);
	public List<NoticiaDto> findByUsuario (String nickname);
	public List<NoticiaDto> findByCategoria (Categoria categoria);
	public int borrarSinComentarios();

}
