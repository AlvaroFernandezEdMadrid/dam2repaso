package com.usuarionoticiacomentario.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usuarionoticiacomentario.models.Usuario;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, String>{

}
