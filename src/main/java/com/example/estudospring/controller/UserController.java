package com.example.estudospring.controller;

import com.example.estudospring.domain.User;
import com.example.estudospring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping// Definição do endpoint base para este controlador
public class UserController {



    private final UserService userService;
    public UserController(UserService userService) {
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

    @DeleteMapping("/usuarios/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
    }

}
