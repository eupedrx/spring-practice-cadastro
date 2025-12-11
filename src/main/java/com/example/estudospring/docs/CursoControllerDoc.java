package com.example.estudospring.docs;


import com.example.estudospring.domain.Curso;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.PreUpdate;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Curso", description = "APIs para manipulação de Curso.")
public interface CursoControllerDoc {


    @Operation(
            summary = "Listar cursos",
            description = "Retorna uma lista dos cursos existentes no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cursos encontrados com sucesso.",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Cursos não encontrados")
    })
    ResponseEntity<String> listarCursos();
    @Operation(summary = "Lista curso por ID", description = "Lista os cursos do sistema por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Curso encontrado",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    ResponseEntity<?> listarCursosPorId(@Parameter(description = "ID do Curso", required = true) Long id);

    @Operation(summary = "Registrar curso", description = "Registra um novo curso no sistema."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Curso registrado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Curso já existente")
    })
    ResponseEntity<String> salvarCurso(@RequestBody Curso curso);

    @Operation(
            summary = "Atualizar curso",
            description = "Atualiza completamente os dados de um curso existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<?> atualizarCurso(@Parameter(description = "ID do Curso", required = true) Long id, @RequestBody Curso curso);

    @Operation(summary = "Deletar Curso", description = "Deleta o curso na sistema por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Curso deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    void deletarCurso(@Parameter(description = "ID do Curso", required = true) Long id);

}
