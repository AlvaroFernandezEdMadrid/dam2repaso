package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import com.usuarionoticiacomentario.models.Usuario;


public interface IUsuarioService {
	public boolean insert (Usuario usuario);

	public boolean update (Usuario usuario);

	public boolean delete (String id);

	public List<Usuario> findAll ();

	public Optional <Usuario> findByNif (String nif);
}
