package com.usuarionoticiacomentario;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.usuarionoticiacomentario.models.Categoria;
import com.usuarionoticiacomentario.models.Comentario;
import com.usuarionoticiacomentario.models.Noticia;
import com.usuarionoticiacomentario.models.Usuario;
import com.usuarionoticiacomentario.services.IComentarioService;
import com.usuarionoticiacomentario.services.INoticiaService;
import com.usuarionoticiacomentario.services.IUsuarioService;

@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner{

	@Autowired 
	private INoticiaService noticiaServicio;
	@Autowired 
	private IComentarioService comentarioServicio;
	@Autowired 
	private IUsuarioService usuarioServicio;

	private static boolean datosCargados = false;

	@Override
	public void run(String... args) throws Exception {

		if (!datosCargados) {
			datosCargados = true;

			// Crear usuarios
			Usuario u1 = Usuario.builder()
					.nickname("Usu1")
					.password("Usu1")
					.build();
			Usuario u2 = Usuario.builder()
					.nickname("Usu2")
					.password("Usu2")
					.build();
			Usuario u3 = Usuario.builder()
					.nickname("Usu3")
					.password("Usu3")
					.build();

			usuarioServicio.insert(u1);
			usuarioServicio.insert(u2);
			usuarioServicio.insert(u3);

			// Crear noticias
			Noticia n1 = Noticia.builder()
					.titulo("Noticia 1")
					.cuerpo("Cuerpo noticia 1")
					.categoria(Categoria.POLITICA)
					.fecha(LocalDate.now())
					.redactor(u1)
					.build();
			Noticia n2 = Noticia.builder()
					.titulo("Noticia 2")
					.cuerpo("Cuerpo noticia 2")
					.categoria(Categoria.DEPORTES)
					.fecha(LocalDate.now())
					.redactor(u2)
					.build();
			Noticia n3 = Noticia.builder()
					.titulo("Noticia 3")
					.cuerpo("Cuerpo noticia 3")
					.categoria(Categoria.POLITICA)
					.fecha(LocalDate.now())
					.redactor(u3)
					.build();

			noticiaServicio.insert(n1);
			noticiaServicio.insert(n2);
			noticiaServicio.insert(n3);

			// Crear comentarios
			Comentario c1 = Comentario.builder()
					.autor(u3)
					.noticia(n1)
					.contenido("Contenido comentario 1")
					.fecha(LocalDate.now().minusMonths(1))
					.valoracion(3)
					.build();
			Comentario c2 = Comentario.builder()
					.autor(u3)
					.noticia(n2)
					.contenido("Contenido comentario 2")
					.fecha(LocalDate.now())
					.valoracion(5)
					.build();
			Comentario c3 = Comentario.builder()
					.autor(u1)
					.noticia(n2)
					.contenido("Contenido comentario 3")
					.fecha(LocalDate.now())
					.valoracion(4)
					.build();

			comentarioServicio.insert(c1);
			comentarioServicio.insert(c2);
			comentarioServicio.insert(c3);


			System.out.println("DATOS CARGADOS");

		}

	}
}
