package com.nivel3.usarioUUID.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nivel3.usarioUUID.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	Optional<Usuario> findByUsername(String username);

}

