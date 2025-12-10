package com.example.estudospring.docs;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Tag(name = "Autenticação", description = "APIs para registro e login de usuários")
public interface AuthControllerDoc {

    @Operation(
            summary = "Registrar novo usuário",
            description = "Cria um novo usuário no sistema com nome e senha"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Usuário já existe")
    })
    ResponseEntity<?> register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do usuário",
                    required = true,
                    content = @Content(
                            schema = @Schema(
                                    example = "{\"name\": \"joao\", \"password\": \"senha123\"}"
                            )
                    )
            )
            Map<String, String> request
    );

    @Operation(
            summary = "Realizar login",
            description = "Autentica o usuário e retorna um token JWT"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(example = "{\"token\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...\"}"))),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    ResponseEntity<?> login(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Credenciais do usuário",
                    required = true,
                    content = @Content(
                            schema = @Schema(
                                    example = "{\"name\": \"joao\", \"password\": \"senha123\"}"
                            )
                    )
            )
            Map<String, String> request
    );
}

