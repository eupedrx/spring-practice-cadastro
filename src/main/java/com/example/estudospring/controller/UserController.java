package com.example.estudospring.controller;

import com.example.estudospring.docs.UserControllerDoc;
import com.example.estudospring.domain.User;
import com.example.estudospring.dto.UpdateUserRequest;
import com.example.estudospring.security.SecurityConfig;
import com.example.estudospring.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping// Definição do endpoint base para este controlador
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class UserController implements UserControllerDoc {



    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usuarios")
    @Override
    public ResponseEntity<String> listarUsuarios() {
        return ResponseEntity.ok("Lista de usuários" + userService.listarUsuarios() );

    }
    @GetMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<?> listarUsuariosPorId(@PathVariable Long id) {
            return ResponseEntity.ok(userService.listarUsuariosPorId(id));

        }

    @PutMapping("/usuarios/{id}")
    @Override
    public ResponseEntity<?> atualizarUser(@PathVariable Long id,
                                        @RequestBody UpdateUserRequest request) {
        User user = userService.atualizarUser(id, request.getName());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/usuarios/deletar/{id}")
    @Override
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
    }

}
