package com.nivel3.usarioUUID.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nivel3.usarioUUID.dto.UsuarioRequestDto;
import com.nivel3.usarioUUID.dto.UsuarioResponseDto;
import com.nivel3.usarioUUID.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	
	
	public UsuarioController(UsuarioService usarioService) {
	this.usuarioService = usarioService;
}
	
	@GetMapping
	public List<UsuarioResponseDto> getAllUsers(){
		return usuarioService.getAllUsers();
	}
	
	@PostMapping
	public UsuarioResponseDto createUser(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.createUser(usuarioRequestDto);
	}
	
	@PutMapping("/{username}")
	public UsuarioResponseDto updateUser(@PathVariable String username, @Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.updateUser(username, usuarioRequestDto);
	}
	
	@DeleteMapping("{username}")
	public UsuarioResponseDto deleteUser(@PathVariable String username) {
		return usuarioService.deleteUser(username);
		
	}

}



