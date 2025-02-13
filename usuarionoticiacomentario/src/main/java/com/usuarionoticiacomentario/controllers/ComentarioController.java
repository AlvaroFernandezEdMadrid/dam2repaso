package com.usuarionoticiacomentario.controllers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarionoticiacomentario.models.Comentario;
import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.services.IComentarioService;
import com.usuarionoticiacomentario.services.INoticiaService;

@RestController
@RequestMapping("noticias/comentario")
public class ComentarioController {
	@Autowired private IComentarioService comentarioService;
	@Autowired private INoticiaService noticiaService;

	@GetMapping("/consultar")
	public ResponseEntity<List<Comentario>> obtenerTodosComentarios() {
		List<Comentario> comentarios;

		try {
			comentarios = comentarioService.findAll();
		} catch (Exception e) {
			comentarios = Collections.emptyList();
		}

		return comentarios.isEmpty() 
				? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(comentarios) 
						: ResponseEntity.ok(comentarios);
	}

	@GetMapping("/consultarpornoticia/{tituloNoticia}")
	public ResponseEntity<List<Comentario>> obtenerComentariosPorNoticia(@PathVariable String tituloNoticia) {
		List<Comentario> comentarios;

		try {
			List<Noticia> noticias = noticiaService.findByTitulo(tituloNoticia);

			comentarios = noticias.isEmpty() 
					? Collections.emptyList() 
							: noticias.stream()
							.flatMap(noticia -> comentarioService.findByNoticia(noticia).stream())
							.collect(Collectors.toList());
		} catch (Exception e) {
			comentarios = Collections.emptyList();
		}

		return comentarios.isEmpty()
				? ResponseEntity.status(HttpStatus.NOT_FOUND).body(comentarios)
						: ResponseEntity.ok(comentarios);
	}


	@PostMapping("/insertar")
	public ResponseEntity<Comentario> insertarComentario(@RequestBody Comentario comentario) {
		HttpStatus status;

		try {
			comentario = comentarioService.insert(comentario);

			status = (comentario.getId() == 0) ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(comentario, status);
	}



}
