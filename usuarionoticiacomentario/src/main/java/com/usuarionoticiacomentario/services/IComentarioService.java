package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import com.usuarionoticiacomentario.models.Comentario;

public interface IComentarioService{
	public Comentario insert(Comentario c);
	public Optional<Comentario> finById(int id);
	public List<Comentario> findAll();
	public List<Comentario> finByNoticia(String tituloNoticia);
	public boolean delete(int id);
}
