package com.david.Pomodoro.services;

import com.david.Pomodoro.entities.Usuario;
import com.david.Pomodoro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> update(Long id, Usuario usuarioDetails) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setUsername(usuarioDetails.getUsername());
            usuario.setPassword(usuarioDetails.getPassword());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setSesiones(usuarioDetails.getSesiones());
            usuario.setColor(usuarioDetails.getColor());
            usuario.setAlarma(usuarioDetails.getAlarma());
            return Optional.of(usuarioRepository.save(usuario));
        } else {
            return Optional.empty();
        }
    }
}
