package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dam2.noticias.modelo.data.Comentario;
import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.ComentarioDto;
import org.dam2.noticias.modelo.dto.NoticiaDto;
import org.dam2.noticias.repositorio.ComentarioRepositorio;
import org.dam2.noticias.repositorio.NoticiaRepositorio;
import org.dam2.noticias.repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServicioImp implements IComentarioServicio {

	@Autowired private ComentarioRepositorio comentarioDAO;
	@Autowired private NoticiaRepositorio noticiaDAO;
	@Autowired private UsuarioRepositorio usuarioDAO;
	
	@Autowired private ModelMapper modelMapper; 
	
	@Override
	public ComentarioDto insertar(ComentarioDto comentarioDto) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario;
		Optional<Noticia> noticia;
		Comentario comentario = new Comentario();
		
		usuario = usuarioDAO.findById(comentarioDto.getAutor());
		noticia = noticiaDAO.findById(comentarioDto.getNoticia());
		
		if (usuario.isPresent() && noticia.isPresent())
		{
			comentario = modelMapper.map(comentarioDto, Comentario.class);
			comentario.setAutor(usuario.get());
			comentario.setNoticia(noticia.get());
			comentario = comentarioDAO.save(comentario);
		}
		
		
		return comentario2ComentarioDto(comentario);
	}

	@Override
	public Optional<ComentarioDto> findById(Long id) {
		// TODO Auto-generated method stub
		return comentarioDAO.findById(id).
				map(c -> comentario2ComentarioDto(c));
	}

	@Override
	public List<ComentarioDto> findByNoticia(String titulo) {
		// TODO Auto-generated method stub
		
		return comentarioDAO.findByTituloNoticia(titulo).
						stream().
						map(c -> modelMapper.map(c, ComentarioDto.class)).
						collect(Collectors.toList());
	}

	@Override
	public List<ComentarioDto> findAll() {
		// TODO Auto-generated method stub
		return ((List<Comentario>)comentarioDAO.findAll()).
				stream().
				map(c -> modelMapper.map(c, ComentarioDto.class)).
				collect(Collectors.toList());
				
	}


	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (comentarioDAO.existsById(id))
		{
			comentarioDAO.deleteById(id);
			exito = true;
		}
		return exito;
	}
	
	public ComentarioDto comentario2ComentarioDto (Comentario comentario)
	{
		
		TypeMap<Comentario, ComentarioDto> propertyMapper;
		

		propertyMapper = modelMapper.getTypeMap(Comentario.class, ComentarioDto.class);
		
		if (propertyMapper == null)
			propertyMapper = modelMapper.createTypeMap(Comentario.class, ComentarioDto.class);
		
		// Cambiar todo el autor por su nickname
	    propertyMapper.addMappings(
	      mapper -> mapper.map(src -> src.getAutor().getNickname(),
	    		  				ComentarioDto::setAutor)
	    );
	    
		// Cambiar toda la noticia por su id
	    propertyMapper.addMappings(
	      mapper -> mapper.map(src -> src.getNoticia().getId(),
	    		  				ComentarioDto::setNoticia)
	    );
	    
	    return modelMapper.map(comentario, ComentarioDto.class);
	}

}
