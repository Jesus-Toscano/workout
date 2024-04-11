package com.lcdh.workout.Persistencia.Impl;

import com.lcdh.workout.Models.Usuario;
import com.lcdh.workout.Repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ImplUsuarioDAO implements com.lcdh.workout.Persistencia.IUsuarioDAO {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
