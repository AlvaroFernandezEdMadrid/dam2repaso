package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarionoticiacomentario.models.Usuario;
import com.usuarionoticiacomentario.repos.UsuarioRepo;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired private  UsuarioRepo usuarioDAO;

	@Override
	public boolean insert(Usuario usuario) {
		boolean exito=false;

		if (!usuarioDAO.findById(usuario.getNickname()).isPresent()) {
			usuarioDAO.save(usuario);
			exito=true;
		}

		return exito;
	}

	@Override
	public boolean delete(String id) {
		boolean exito=false;

		if (usuarioDAO.existsById(id)) {
			usuarioDAO.deleteById(id);
			exito=true;
		}

		return exito;
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public Optional<Usuario> findById(String id) {
		return usuarioDAO.findById(id);
	}

	
}
