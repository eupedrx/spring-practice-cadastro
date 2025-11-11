package com.example.estudospring.controller;

import com.example.estudospring.domain.User;
import com.example.estudospring.exceptions.UsuarioNaoEncontradoException;
import com.example.estudospring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping// Definição do endpoint base para este controlador
public class FirstController {



    private final UserService userService;
    public FirstController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<String> listarUsuarios() {
        return ResponseEntity.ok("Lista de usuários" + userService.listarUsuarios() );

    }
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> listarUsuariosPorId(@PathVariable Long id) {
            return ResponseEntity.ok(userService.listarUsuariosPorId(id));

        }

    @PostMapping("/usuarios/salvar")
    public ResponseEntity<String> salvarUsuario(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário salvo com sucesso! ID: " + userService.salvarUsuario(user).getId());
    }

    @DeleteMapping("/usuarios/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
    }

}
