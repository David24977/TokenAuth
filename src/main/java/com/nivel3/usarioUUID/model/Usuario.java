package com.nivel3.usarioUUID.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String username;
	
	@Column(length = 30, nullable = false)
	private String password;
	
	@Column(unique = true)
	private String token;
	
	@Column(name = "token_expiration")
	private LocalDateTime tokenExpiration;

}


