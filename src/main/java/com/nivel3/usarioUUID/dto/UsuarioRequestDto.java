package com.nivel3.usarioUUID.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequestDto {
	@NotBlank(message = "El password no puede quedar vacío")
	@Size(min = 3, max = 30, message = "El username debe tener entre 3 y 30 caracteres")
	private String username;
	
	@NotBlank(message = "El password no puede quedar vacio")
	@Size(min = 6, max = 30, message = "El password debe tener entre 6 y 30 caracteres")
	private String password;

}
