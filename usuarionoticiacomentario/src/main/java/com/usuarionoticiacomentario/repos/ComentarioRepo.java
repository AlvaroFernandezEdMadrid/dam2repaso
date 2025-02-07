package com.usuarionoticiacomentario.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usuarionoticiacomentario.models.Comentario;
import com.usuarionoticiacomentario.models.Noticia;

@Repository
public interface ComentarioRepo extends CrudRepository<Comentario, Integer>{
	public Noticia findByNoticia(Noticia n);
}
