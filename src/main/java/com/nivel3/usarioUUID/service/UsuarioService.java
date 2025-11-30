package com.nivel3.usarioUUID.service;

import java.util.List;

import com.nivel3.usarioUUID.dto.LoginRequestDto;
import com.nivel3.usarioUUID.dto.LoginResponseDto;
import com.nivel3.usarioUUID.dto.UsuarioRequestDto;
import com.nivel3.usarioUUID.dto.UsuarioResponseDto;

public interface UsuarioService {
	
	List<UsuarioResponseDto> getAllUsers();
	
	UsuarioResponseDto getUserbyUsername(String username);
	
	UsuarioResponseDto createUser(UsuarioRequestDto usuarioRequestDto);
	
	UsuarioResponseDto updateUser(String username, UsuarioRequestDto usuarioRequestDto);
	
	LoginResponseDto createToken(LoginRequestDto loginRequestDto);
	
	UsuarioResponseDto deleteUser(String username);
}
