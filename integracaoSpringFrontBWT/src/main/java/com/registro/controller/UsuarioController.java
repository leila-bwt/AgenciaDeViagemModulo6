package com.registro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.model.Usuario;
import com.registro.service.UsuarioService;

@Service
@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") long usuarioid ) {
		return new ResponseEntity<Usuario>(service.getUsuariosById(usuarioid), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuario = service.getAllUsuario();
		return ResponseEntity.ok().body(usuario);	
		}
	
	@PostMapping
	public ResponseEntity<Usuario> saveUsuario (@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(service.saveUsuario(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Usuario> updateUsuarios(@PathVariable("id") long id, 
			@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(service.updateUsuario(usuario, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUsuarios(@PathVariable("id") long id) {
		service.deleteUsuario(id);
	
	return new ResponseEntity<String>("Usuário deletado com sucesso!",
			HttpStatus.OK);
	}
}