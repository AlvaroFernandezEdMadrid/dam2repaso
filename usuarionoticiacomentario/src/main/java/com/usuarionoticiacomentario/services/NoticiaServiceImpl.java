package com.usuarionoticiacomentario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarionoticiacomentario.models.Categoria;
import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.models.Usuario;
import com.usuarionoticiacomentario.repos.NoticiaRepo;
import com.usuarionoticiacomentario.repos.UsuarioRepo;

@Service
public class NoticiaServiceImpl implements INoticiaService{

	@Autowired private UsuarioRepo usuarioDAO;
	@Autowired private NoticiaRepo noticiaDAO;

	@Override
	public boolean insert(Noticia n) {
		boolean exito=false;

		Optional<Usuario> redactor=usuarioDAO.findById(n.getRedactor().getNickname());

		if (redactor.isPresent()) {
			//Aumentar puntos
			redactor.get().aumentarPuntos(n.getCategoria().getPuntos());
			//Guardar redactor actualizado
			usuarioDAO.save(redactor.get());
			//Asignar redactor a noticia
			n.setRedactor(redactor.get());
			//Insertar noticia
			noticiaDAO.save(n);

			exito=true;
		}

		return exito;
	}

	@Override
	public Optional<Noticia> findById(int id) {return noticiaDAO.findById(id);}

	@Override
	public List<Noticia> findByTitulo(String titulo) {return noticiaDAO.findByTitulo(titulo);}

	@Override
	public List<Noticia> findAll() {return (List<Noticia>) noticiaDAO.findAll();}

	@Override
	public List<Noticia> findByUsuario(String usuId) {
		Usuario u=Usuario.builder().nickname(usuId).build();

		return noticiaDAO.findByRedactor(u);
	}

	@Override
	public List<Noticia> findByCategoria(Categoria c) {return noticiaDAO.findByCategoria(c);}

	@Override
	public boolean delete(int id) {
		boolean exito=false;

		if (noticiaDAO.existsById(id)) {
			noticiaDAO.deleteById(id);
			exito=true;
		}

		return exito;
	}

	@Override
	public int deleteByTitulo(String titulo) {return noticiaDAO.deleteByTitulo(titulo);}

}
