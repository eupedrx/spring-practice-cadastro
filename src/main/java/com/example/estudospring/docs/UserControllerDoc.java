package com.example.estudospring.docs;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Usuário", description = "APIs para retorno/deletar Usuários.")
public interface UserControllerDoc {

    @Operation(
            summary = "Lista todos os Usuários",
            description = "Retorna uma lista com todos os Usuários cadastrados no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Não autorizado.")
    })
    ResponseEntity<String> listarUsuarios();

    @Operation(
            summary = "Lista Usuário por ID",
            description = "Retorna as informações não sensiveis de um Usuário por ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    ResponseEntity<?> listarUsuariosPorId(@Parameter(description = "ID do Usuário", required = true) Long id);

    @Operation(
            summary = "Deletar Usuário",
            description = "Remove um Usuário do sistema através do seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    void deletarUsuario(@Parameter(description = "ID do Usuário a ser deletado", required = true) Long id);

}
