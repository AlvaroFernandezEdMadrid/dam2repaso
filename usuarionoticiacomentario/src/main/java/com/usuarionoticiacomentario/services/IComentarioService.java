package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import com.usuarionoticiacomentario.models.Comentario;
import com.usuarionoticiacomentario.models.Noticia;

public interface IComentarioService{
	public Comentario insert(Comentario c);
	public Optional<Comentario> finById(int id);
	public List<Comentario> findAll();
	public List<Comentario> findByNoticia(Noticia noticia);
	public boolean delete(int id);
}
