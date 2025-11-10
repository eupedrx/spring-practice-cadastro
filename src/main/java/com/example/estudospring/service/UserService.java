package com.example.estudospring.service;

import com.example.estudospring.domain.User;
import com.example.estudospring.exceptions.UsuarioNaoEncontradoException;
import com.example.estudospring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User listarUsuariosPorId(Long id) {

        return userRepository.findById(id)
        .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
    }

    public User salvarUsuario(User user) {
        return userRepository.save(user);
    }

    public void deletarUsuario(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
