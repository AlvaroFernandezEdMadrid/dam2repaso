package org.dam2.noticias.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.NoticiaDto;
import org.dam2.noticias.modelo.dto.UsuarioDto;
import org.dam2.noticias.servicio.INoticiaServicio;
import org.dam2.noticias.servicio.IUsuarioServicio;
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


@RestController
@RequestMapping("noticias/usuario")
public class UsuarioControlador {
	
	@Autowired private IUsuarioServicio usuarioServicio;
	@Autowired private INoticiaServicio noticiaServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<UsuarioDto>> obtenerTodosUsuarios ()
	{
		ResponseEntity<List<UsuarioDto>> response;
		List<UsuarioDto> todos;
		
		todos =  usuarioServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}

	
	@GetMapping ("/consultar/{nickName}")
	public ResponseEntity<UsuarioDto> obtenerCliente (@PathVariable String nickName)
	{
		ResponseEntity<UsuarioDto> response;
		Optional<UsuarioDto> usuario;
		
		usuario = usuarioServicio.findByNickName(nickName);
		
		if (usuario.isPresent())
			response = new ResponseEntity<>(usuario.get(),HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return response;
	}
	
	@GetMapping ("/consultarnoticiaspublicadas")
	public ResponseEntity<List<NoticiaDto>> obtenerNoticiasPublicadas (@RequestParam String nickName)
	{
	
		return ResponseEntity.ok(noticiaServicio.findByUsuario (nickName));
	}
	
	
	@PostMapping("/insertar")
	public ResponseEntity<Usuario> insertarUsuario (@RequestBody Usuario usuario)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		if (!usuarioServicio.insertar(usuario))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(usuario,status);
	}
	
}
