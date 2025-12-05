package com.example.estudospring.service;

import com.example.estudospring.domain.User;
import com.example.estudospring.exceptions.UsuarioNaoEncontradoException;
import com.example.estudospring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(String name, String password){
        String cryptPassword = passwordEncoder.encode(password);
        User user = new User(name, cryptPassword);
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }


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
