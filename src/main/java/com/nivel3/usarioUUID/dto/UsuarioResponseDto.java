package com.nivel3.usarioUUID.dto;

import java.time.LocalDateTime;

public record UsuarioResponseDto(String username, LocalDateTime tokenExpiration) {

}
