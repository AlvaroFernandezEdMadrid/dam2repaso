package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.data.Noticia;
import org.dam2.noticias.modelo.data.Usuario;
import org.dam2.noticias.modelo.dto.UsuarioDto;

public interface IUsuarioServicio {
	public boolean insertar (Usuario usuario);
	public Optional<UsuarioDto> findByNickName (String nickName);
	public List<UsuarioDto> findAll ();
	public boolean update (Usuario usuario);
	public boolean delete (String nickName);
	
}
