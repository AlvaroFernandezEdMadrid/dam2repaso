package com.usuarionoticiacomentario.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usuarionoticiacomentario.models.Categoria;
import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.models.Usuario;

@Repository
public interface NoticiaRepo extends CrudRepository<Noticia, Integer>{
	List<Noticia> findByTitulo(String titulo);

	int deleteByTitulo(String titulo);

	List<Noticia> findByRedactor(Usuario redactor);

	List<Noticia> findByCategoria (Categoria categoria);
}
