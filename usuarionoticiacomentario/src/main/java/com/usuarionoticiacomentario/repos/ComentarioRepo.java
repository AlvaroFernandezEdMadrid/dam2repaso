package com.usuarionoticiacomentario.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usuarionoticiacomentario.models.Comentario;
import com.usuarionoticiacomentario.models.Noticia;

@Repository
public interface ComentarioRepo extends CrudRepository<Comentario, Integer>{
	public List<Comentario> findByNoticia(Noticia n);
}
