package com.gateway.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.model.Usuario;
import com.gateway.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

}
