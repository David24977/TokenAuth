package com.nivel3.usarioUUID.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Gestión usuarios con token",
        version = "1.0.0",
        description = "API REST para gestionar entrada de usuarios mediante token"
    )
)
public class OpenApiConfig {}
