package com.gateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByNome(String usuario);

}
