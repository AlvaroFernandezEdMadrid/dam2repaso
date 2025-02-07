package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import com.usuarionoticiacomentario.models.Categoria;
import com.usuarionoticiacomentario.models.Noticia;

public interface INoticiaService {
	public boolean insert(Noticia n);
	
	public Optional<Noticia> findById(int id);
	public List<Noticia> findByTitulo(String titulo);
	public List<Noticia> findAll();
	public List<Noticia> findByUsuario(String usuId);
	public List<Noticia> findByCategoria(Categoria c);
	
	public boolean delete(int id);
	public int deleteByTitulo(String titulo);
	
}
