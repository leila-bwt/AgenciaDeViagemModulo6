package com.registro.service;

import java.util.List;

import com.registro.model.Usuario;


public interface UsuarioService {

	Usuario saveUsuario(Usuario usuario);
	List<Usuario> getAllUsuario();
	Usuario getUsuariosById(Long id);
	Usuario updateUsuario(Usuario usuario, Long id);
	void deleteUsuario(Long id);
	
	
}
