package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarionoticiacomentario.models.Comentario;
import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.repos.ComentarioRepo;

@Service
public class ComentarioServiceImpl implements IComentarioService{

	@Autowired private ComentarioRepo comentarioDAO;
	
	@Override
	public Comentario insert(Comentario c) {
		return comentarioDAO.save(c);
	}

	@Override
	public Optional<Comentario> finById(int id) {return comentarioDAO.findById(id);}

	@Override
	public List<Comentario> findAll() {return (List<Comentario>) comentarioDAO.findAll();}

	@Override
	public List<Comentario> findByNoticia(Noticia noticia) {return comentarioDAO.findByNoticia(noticia);}

	@Override
	public boolean delete(int id) {
		boolean exito=false;
		
		if (comentarioDAO.existsById(id)) {
			comentarioDAO.deleteById(id);
			exito=true;
		}
		
		return exito;
	}

	

}
