package com.usuarionoticiacomentario.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.models.Usuario;
import com.usuarionoticiacomentario.services.INoticiaService;
import com.usuarionoticiacomentario.services.IUsuarioService;

@RestController
@RequestMapping("noticias/usuario")
public class UsuarioController {

	@Autowired private IUsuarioService usuarioService;

	@Autowired private INoticiaService noticiaService;

	@GetMapping("/consultar")
	public ResponseEntity<List<Usuario>> getAllUsers() {

		ResponseEntity<List<Usuario>> response;

		try {

			List<Usuario> usuarios = usuarioService.findAll();

			if (usuarios.isEmpty()) {
				response = ResponseEntity.noContent().build();
			} else {
				response = ResponseEntity.ok(usuarios);  
			}

		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		}

		return response;
	}

	@GetMapping("/consultar/{nickName}")
	public ResponseEntity<Usuario> obtenerCliente(@PathVariable String nickName) {
		ResponseEntity<Usuario> response;

		try {
			Optional<Usuario> usuario = usuarioService.findById(nickName);

			response = usuario
					.map(user -> new ResponseEntity<>(user, HttpStatus.OK))  
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		return response;
	}

	@GetMapping("/consultarnoticiaspublicadas")
	public ResponseEntity<List<Noticia>> obtenerNoticiasDeUsuario(@RequestParam String nickName) {
		ResponseEntity<List<Noticia>> response;

		try {
			List<Noticia> noticias = noticiaService.findByUsuario(nickName);

			if (noticias.isEmpty()) {
				response = ResponseEntity.noContent().build();
			} else {
				response = ResponseEntity.ok(noticias);
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();}

		return response;
	}

	@PostMapping("/insertarusuario")
	public ResponseEntity<Usuario> insertarusuario (@RequestBody Usuario usuario){
		ResponseEntity<Usuario> response;

	    try {
	        boolean isInserted = usuarioService.insert(usuario);
	        
	        if (isInserted) {
	            response = new ResponseEntity<>(usuario, HttpStatus.CREATED);
	        } else {
	            response = new ResponseEntity<>(usuario, HttpStatus.BAD_REQUEST);
	        }
	    } catch (Exception e) {
	        response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    return response;
	}


}
