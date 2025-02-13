package com.usuarionoticiacomentario.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usuarionoticiacomentario.models.Categoria;
import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.services.IComentarioService;
import com.usuarionoticiacomentario.services.INoticiaService;

@RestController
@RequestMapping("noticias/noticia")
public class NoticiaController {

	@Autowired private INoticiaService noticiaService;
	@Autowired private IComentarioService comentarioService;

	@GetMapping("/consultar")
	public ResponseEntity<List<Noticia>> obtenerTodasNoticias() {
		ResponseEntity<List<Noticia>> response;

		try {
			List<Noticia> noticias = noticiaService.findAll();

			response = noticias.isEmpty() 
					? ResponseEntity.noContent().build() 
							: ResponseEntity.ok(noticias);       

		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();}

		return response;
	}

	@GetMapping("/consultar/{id}")
	public ResponseEntity<Noticia> obtenerNoticia(@PathVariable int id) {
		ResponseEntity<Noticia> response;

		try {
			Optional<Noticia> noticia = noticiaService.findById(id);

			response = noticia
					.map(n -> ResponseEntity.ok(n))
					.orElseGet(() -> ResponseEntity.notFound().build());

		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();}

		return response;
	}

	@GetMapping("/consultarporcategoria")
	public ResponseEntity<List<Noticia>> obtenerNoticiasPorCategoria(@RequestParam Categoria categoria) {
		ResponseEntity<List<Noticia>> response;

		try {
			if (categoria == null) {
				response = ResponseEntity.badRequest().build();
			} else {
				List<Noticia> noticias = noticiaService.findByCategoria(categoria);

				if (noticias == null || noticias.isEmpty()) {
					response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				} else {
					response = ResponseEntity.ok(noticias);
				}
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return response;
	}

	@PostMapping("/insertar")
	public ResponseEntity<Noticia> insertarNoticia(@RequestBody Noticia noticia) {
		HttpStatus status = HttpStatus.CREATED;

		try {
			boolean exito = noticiaService.insert(noticia);

			if (!exito) {
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(noticia, status);
	}

	@DeleteMapping("/eliminarnoticiasnocomentadas")
	public ResponseEntity<Integer> eliminarNoticiasSinComentarios (){
		try {
			// Obtener todas las noticias que no tienen comentarios
			List<Noticia> noticiasSinComentarios = noticiaService.findAll().stream()
					.filter(noticia -> comentarioService.findByNoticia(noticia).isEmpty())
					.collect(Collectors.toList());

			// Eliminar las noticias que no tienen comentarios
			int eliminadas = 0;
			for (Noticia noticia : noticiasSinComentarios) {
				noticiaService.delete(noticia.getId());
				eliminadas++;
			}

			return ResponseEntity.ok(eliminadas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build(); 
		}
	}



}
