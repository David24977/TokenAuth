package com.nivel3.usarioUUID.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nivel3.usarioUUID.dto.LoginRequestDto;
import com.nivel3.usarioUUID.dto.LoginResponseDto;
import com.nivel3.usarioUUID.dto.UsuarioRequestDto;
import com.nivel3.usarioUUID.dto.UsuarioResponseDto;
import com.nivel3.usarioUUID.model.Usuario;
import com.nivel3.usarioUUID.repository.UsuarioRepository;
import com.nivel3.usarioUUID.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Value("${token.expiration.hours}")
	private int tokenHours;
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<UsuarioResponseDto> getAllUsers() {
		return usuarioRepository.findAll()
				.stream()
				.map(this::mapToResponse)
				.toList();
	}
	

	@Override
	public UsuarioResponseDto getUserbyUsername(String username) {
		Usuario encontradoUsuario = usuarioRepository.findByUsername(username)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
		return mapToResponse(encontradoUsuario);
	}

	@Override
	public UsuarioResponseDto createUser(UsuarioRequestDto usuarioRequestDto) {
		Usuario creadoUsuario = new Usuario();
		
		creadoUsuario.setUsername(usuarioRequestDto.getUsername());
		creadoUsuario.setPassword(usuarioRequestDto.getPassword());
		
		usuarioRepository.save(creadoUsuario);
		return mapToResponse(creadoUsuario);
	}
	

	@Override
	public UsuarioResponseDto updateUser(String username, UsuarioRequestDto usuarioRequestDto) {
		Usuario actualizado = usuarioRepository.findByUsername(username)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
		
		if(usuarioRequestDto.getUsername() != null) {
			actualizado.setUsername(usuarioRequestDto.getUsername());
		}
		
		if(usuarioRequestDto.getPassword() != null) {
			actualizado.setPassword(usuarioRequestDto.getPassword());
		}
		
		usuarioRepository.save(actualizado);
		
		return mapToResponse(actualizado);
	}

	@Override
	public LoginResponseDto createToken(LoginRequestDto loginRequestDto) {
		
		Usuario tokenUsuario = usuarioRepository.findByUsername(loginRequestDto.getUsername())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
		
		if(!tokenUsuario.getPassword().equals(loginRequestDto.getPassword())) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password erronéo");
		}
		
		String token = UUID.randomUUID().toString();
		
		LocalDateTime expiration = LocalDateTime.now().plusHours(tokenHours);
		
		tokenUsuario.setToken(token);
		tokenUsuario.setTokenExpiration(expiration);
		
		usuarioRepository.save(tokenUsuario);
		
				
		return new LoginResponseDto(
				tokenUsuario.getToken(),
				tokenUsuario.getTokenExpiration()
				);
		}
	

	@Override
	public UsuarioResponseDto deleteUser(String username) {
		Usuario eliminado = usuarioRepository.findByUsername(username)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
		
		usuarioRepository.delete(eliminado);
		return mapToResponse(eliminado);
	}
	
	
	private UsuarioResponseDto mapToResponse(Usuario usuario) {
		return new UsuarioResponseDto(
				usuario.getUsername(),
				usuario.getTokenExpiration());
				
	}
	
}

