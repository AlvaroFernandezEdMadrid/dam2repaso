package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.UsuarioDto;
import org.dam2.noticias.repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

	@Autowired private UsuarioRepositorio usuarioDAO;
	@Autowired private ModelMapper modelMapper; 
	
	private final Function<Usuario,UsuarioDto> DATA2DTO = 
			usuario -> modelMapper.map(usuario, UsuarioDto.class);
	
	private final Function<UsuarioDto,Usuario> DTO2DATA = 
			usuarioDto -> modelMapper.map(usuarioDto, Usuario.class);
			
	
	@Override
	public boolean insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!usuarioDAO.existsById(usuario.getNickname()))
		{
			usuarioDAO.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public Optional<UsuarioDto> findByNickName(String nickName) {
		// TODO Auto-generated method stub
		
		return usuarioDAO.findById(nickName).
				map(DATA2DTO);
	}

	@Override
	public List<UsuarioDto> findAll() {
		// TODO Auto-generated method stub
		return ((List<Usuario>) usuarioDAO.findAll()).stream().
					map(DATA2DTO).
					collect(Collectors.toList());
	}

	@Override
	public boolean update(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (usuarioDAO.existsById(usuario.getNickname()))
		{
			usuarioDAO.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(String nickName) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (usuarioDAO.existsById(nickName))
		{
			usuarioDAO.deleteById(nickName);
			exito = true;
		}
		return exito;
	}

}
