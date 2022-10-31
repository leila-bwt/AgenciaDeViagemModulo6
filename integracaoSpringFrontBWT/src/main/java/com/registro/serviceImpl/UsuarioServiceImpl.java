package com.registro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.exception.ObjectNotFoundException;
import com.registro.model.Usuario;
import com.registro.repositories.UsuarioRepository;
import com.registro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuario getUsuariosById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() ->
				new ObjectNotFoundException("Usuário", "id", id));
	}
	
	@Override
	public Usuario updateUsuario(Usuario usuarios, Long id) {
		
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() ->
				new ObjectNotFoundException("Usuario", "id", id));
		
		usuarioExistente.setNome(usuarios.getNome());
		usuarioExistente.setEndereço(usuarios.getEndereço());
		usuarioExistente.setCidade(usuarios.getCidade());
		usuarioExistente.setEstado(usuarios.getEstado());
		usuarioExistente.setCep(usuarios.getCep());
		usuarioExistente.setEmail(usuarios.getEmail());
		usuarioExistente.setSenha(usuarios.getSenha());
		
		usuarioRepository.save(usuarioExistente);
		return usuarioExistente;
	}
	
	@Override
	public void deleteUsuario(Long id) {
		usuarioRepository.findById(id).orElseThrow(() ->
				new ObjectNotFoundException("Usuarios", "id", id));
	}
}
	