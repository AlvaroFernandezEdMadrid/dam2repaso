package org.dam2.noticias.controlador;

import java.util.List;

import org.dam2.noticias.modelo.dto.ComentarioDto;
import org.dam2.noticias.servicio.IComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("noticias/comentario")
public class ComentarioControlador {
	
	@Autowired private IComentarioServicio comentarioServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<ComentarioDto>> obtenerTodosComentarios ()
	{

		return ResponseEntity.ok(comentarioServicio.findAll());
	}
	
	@GetMapping ("/consultarpornoticia/{titulo}")
	public ResponseEntity<List<ComentarioDto>> obtenerComentariosPorNoticia (@PathVariable String titulo)
	{	
		return ResponseEntity.ok(comentarioServicio.findByNoticia(titulo));	
	}
	
	
	@PostMapping("/insertar")
	public ResponseEntity<ComentarioDto> insertarComentario (@RequestBody ComentarioDto comentario)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		
		comentario = comentarioServicio.insertar(comentario);
		
		if (comentario.getId() == 0)
			status = HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<>(comentario,status);
	}

	

}
