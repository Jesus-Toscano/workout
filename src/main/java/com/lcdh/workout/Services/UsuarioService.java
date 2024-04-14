package com.lcdh.workout.Services;

import com.lcdh.workout.Models.Usuario;
import com.lcdh.workout.Repositories.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }


    public Optional<Usuario> findById(Long id) {
        return usuarioRepositorio.findById(id);
    }


    public void save(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }


    public void deleteById(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
