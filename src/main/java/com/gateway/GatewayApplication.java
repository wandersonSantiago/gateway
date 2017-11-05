package com.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gateway.enuns.Perfil;
import com.gateway.filters.SimpleFilter;
import com.gateway.model.Usuario;
import com.gateway.repositories.UsuarioRepository;


@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication implements CommandLineRunner{

	 @Autowired
	  private UsuarioRepository usuarioRepository;
	 @Autowired
	 private BCryptPasswordEncoder password;
	 
  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public SimpleFilter simpleFilter() {
    return new SimpleFilter();
  }
  
	@Override
	public void run(String... arg0) throws Exception {
		
		Usuario user = new Usuario();
		user.setNome("admin");
		user.setSenha(password.encode("admin"));
		user.addPerfil(Perfil.ADMIN);
		usuarioRepository.save(user);
		
	}
	 
}
