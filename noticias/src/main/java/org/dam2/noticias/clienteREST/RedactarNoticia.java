package org.dam2.noticias.clienteREST;

import java.time.LocalDate;
import java.util.Optional;

import org.dam2.noticias.modelo.data.Categoria;
import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.NoticiaDto;
import org.dam2.noticias.modelo.dto.UsuarioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class RedactarNoticia {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilidadesCliente.cargarDatos();

		//solicitar redactor noticia
		UtilidadesCliente.solicitarUsuario().
		ifPresentOrElse(
				redactor -> crearNoticia (redactor), 
				()-> System.out.println("redactor no existente")
				);

	}

	public static void crearNoticia (UsuarioDto redactor)
	{
		
		// solicitar datos de noticia
		NoticiaDto noticia = NoticiaDto.builder().
				redactor(redactor.getNickname()).
				fecha(LocalDate.now()).
				build();
		noticia.setTitulo(Teclado.leerString("\nTítulo "));
		noticia.setCuerpo(Teclado.leerString("\nContenido "));
		noticia.setCategoria(Categoria.ECONOMIA);
		// insertar noticia
		insertarNoticia (noticia);

	}
	public static void insertarNoticia(NoticiaDto noticia) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <NoticiaDto> response;
		String URL = UtilidadesCliente.URLBASE + "/noticia/insertar";

		try {
			response = restTemplate.postForEntity(URL, noticia,NoticiaDto.class);
			noticia = response.getBody();
			System.out.println("Noticia insertada correctamente");
			System.out.println("Identificador asignado " + noticia.getId());

		}
		catch (RestClientException e)
		{
			System.out.println("Error insertando noticia...");
		}


	}

	
}
