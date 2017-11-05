package com.gateway.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.model.Usuario;
import com.gateway.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios =  usuarioService.findAll();
		 return  ResponseEntity.ok().body(usuarios);
	}

}
