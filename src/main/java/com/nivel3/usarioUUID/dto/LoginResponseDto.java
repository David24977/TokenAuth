package com.nivel3.usarioUUID.dto;

import java.time.LocalDateTime;

public record LoginResponseDto(String token, LocalDateTime tokenExpiration) {

}

