package com.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gateway.model.Usuario;
import com.gateway.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByNome(usuario);
		if(user == null){
			throw new UsernameNotFoundException(usuario); 
		}
		return new UserSS(user.getId(), user.getNome(), user.getSenha(), user.getPerfis());
	}



}
