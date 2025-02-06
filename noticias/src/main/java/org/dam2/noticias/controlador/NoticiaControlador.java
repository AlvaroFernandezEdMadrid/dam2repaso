package org.dam2.noticias.controlador;

import java.util.List;
import java.util.Optional;

import org.dam2.noticias.modelo.data.Categoria;
import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.NoticiaDto;
import org.dam2.noticias.servicio.INoticiaServicio;
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

@RestController
@RequestMapping("noticias/noticia")
public class NoticiaControlador {
	
	@Autowired private INoticiaServicio noticiaServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<NoticiaDto>> obtenerTodoasNoticias ()
	{

		return ResponseEntity.ok(noticiaServicio.findAll());
	}

	@GetMapping ("/consultar/{id}")
	public ResponseEntity<NoticiaDto> obtenerNoticia (@PathVariable Long id)
	{
		return ResponseEntity.of(noticiaServicio.findById(id));
	}
	
	
	@GetMapping ("/consultarporcategoria")
	public ResponseEntity<List<NoticiaDto>> obtenerNoticiasPorCategoria (@RequestParam Categoria categoria)
	{

		return ResponseEntity.ok(noticiaServicio.findByCategoria(categoria));
	}

	@PostMapping("/insertar")
	public ResponseEntity<NoticiaDto> insertarNoticia (@RequestBody NoticiaDto noticia)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		noticia = noticiaServicio.insertar(noticia);
		
		if (noticia.getId() == 0)
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(noticia,status);
	}
	
	@DeleteMapping("/eliminarnoticiasnocomentadas")
	public ResponseEntity<Integer> eliminarNoticiasNoComentadas ()
	{
		return ResponseEntity.ok(noticiaServicio.borrarSinComentarios());
	}
}
