package com.example.estudospring.docs;


import com.example.estudospring.domain.Aluno;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Aluno", description = "APIs para manipulação de Aluno.")
public interface AlunoControllerDoc {

    @Operation(
            summary = "Lista todos os Alunos",
            description = "Retorna uma lista com todos os alunos cadastrados no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Não autorizado.")
    })
    ResponseEntity<String> listarAlunos();

    @Operation(
            summary = "Lista aluno por ID",
            description = "Retorna as informações não sensiveis de um Aluno por ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno encontrado",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    ResponseEntity<?> listarAlunosPorId(@Parameter(description = "ID do Aluno", required = true) Long id);

    @Operation(
            summary = "Cadastrar novo aluno",
            description = "Cria um novo aluno no sistema com os dados fornecidos"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    ResponseEntity<String> salvarAluno(
            @Parameter(description = "Dados do aluno a ser cadastrado", required = true) Aluno aluno
    );

    @Operation(
            summary = "Atualizar aluno",
            description = "Atualiza completamente os dados de um aluno existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<?> atualizarAluno(@Parameter(description = "ID de Aluno", required = true) Long id, @RequestBody Aluno alunoAtualizado);

    @Operation(
            summary = "Deletar aluno",
            description = "Remove um aluno do sistema através do seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Aluno deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    void deletarAluno(
            @Parameter(description = "ID do aluno a ser deletado", required = true) Long id);
}