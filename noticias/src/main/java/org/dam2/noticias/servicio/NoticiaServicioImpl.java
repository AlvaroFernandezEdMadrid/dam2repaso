package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dam2.noticias.modelo.data.Categoria;
import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.NoticiaDto;
import org.dam2.noticias.repositorio.NoticiaRepositorio;
import org.dam2.noticias.repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServicioImpl implements INoticiaServicio {

	@Autowired private NoticiaRepositorio noticiaDAO;
	@Autowired private UsuarioRepositorio usuarioDAO;
	@Autowired private ModelMapper modelMapper; 
	
	
	
	@Override
	@Transactional
	public NoticiaDto insertar(NoticiaDto noticiaDto) {
		// TODO Auto-generated method stub
		Optional<Usuario> redactor;
		Noticia noticia;
		
	
		redactor = usuarioDAO.findById(noticiaDto.getRedactor());
		
		if (redactor.isPresent())
		{
			//Actualizar puntos redactor
			redactor.get().aumentarPuntos(noticiaDto.getCategoria().ordinal() + 1);
			usuarioDAO.save(redactor.get());
			// insertar noticia
			noticia = modelMapper.map(noticiaDto,Noticia.class);
			noticia.setRedactor(redactor.get());
			noticiaDAO.save(noticia);
			noticiaDto.setId(noticia.getId());
		}
		
		return noticiaDto;
	}

	@Override
	public Optional<NoticiaDto> findById(Long id) {
		// TODO Auto-generated method stub
		

	    // convertir noticia a noticiadto
		return noticiaDAO.findById(id).map(n -> noticia2NoticiaDto(n));
	}

	@Override
	public List<NoticiaDto> findByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return noticiaDAO.findByTitulo(titulo).
				stream().
				map(n -> noticia2NoticiaDto(n)).
				collect(Collectors.toList());
	}

	@Override
	public List<NoticiaDto> findAll() {
		// TODO Auto-generated method stub
		return ((List<Noticia>) noticiaDAO.findAll()).
				stream().
				map(n -> noticia2NoticiaDto(n)).
				collect(Collectors.toList());
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (noticiaDAO.existsById(id))
		{
			noticiaDAO.deleteById(id);
			exito = true;
		}
		return exito;
	}

	@Override
	@Transactional
	public int deleteByTitulo(String titulo) {
		// TODO Auto-generated method stub
		
		
		return (int) noticiaDAO.deleteByTitulo(titulo);
	}

	@Override
	public List<NoticiaDto> findByUsuario(String nickname) {
		// TODO Auto-generated method stub
		Usuario redactor = Usuario.builder().nickname(nickname).build();
		
		return noticiaDAO.findByRedactor(redactor).
				stream().
				map(n -> noticia2NoticiaDto(n)).
				collect(Collectors.toList());
	}

	@Override
	public List<NoticiaDto> findByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return noticiaDAO.findByCategoria(categoria).
				stream().
				map(n -> noticia2NoticiaDto(n)).
				collect(Collectors.toList());
	}

	@Override
	@Transactional
	public int borrarSinComentarios() {
		// TODO Auto-generated method stub
		return (int) noticiaDAO.deleteNoticiasSinComentarios();
	}
	
	public NoticiaDto noticia2NoticiaDto (Noticia n)
	{
		NoticiaDto noticiaDto;
		TypeMap<Noticia, NoticiaDto> propertyMapper;
		
		propertyMapper = modelMapper.getTypeMap (Noticia.class, NoticiaDto.class);
		
		if (propertyMapper == null)
			propertyMapper = modelMapper.createTypeMap(Noticia.class, NoticiaDto.class);
	    
		// Lo hace por defecto no hay que hacerlo
		/*
		 propertyMapper.addMappings(
			      mapper -> mapper.map(src -> src.getId(),
			    		  				NoticiaDto::setId)
			    );
		*/
		// ...Igual con el resto de propiedades
		
		// Esta propiedad la queremos adaptar
		// Cambiar todo el redactor por su nickname
	    propertyMapper.addMappings(
	      mapper -> mapper.map(src -> src.getRedactor().getNickname(),
	    		  				NoticiaDto::setRedactor)
	    );
	    
	    noticiaDto = modelMapper.map(n, NoticiaDto.class);
	    
	    return noticiaDto;
		
	}
	
	

}
