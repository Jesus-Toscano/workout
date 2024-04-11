package com.lcdh.workout.Services.Impl;

import com.lcdh.workout.Models.Usuario;
import com.lcdh.workout.Persistencia.Impl.ImplUsuarioDAO;
import com.lcdh.workout.Services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplUsuarioService  implements IUsuarioService {
    @Autowired
    private ImplUsuarioDAO implUsuarioDAO;
    @Override
    public List<Usuario> findAll() {
        return implUsuarioDAO.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return implUsuarioDAO.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        implUsuarioDAO.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        implUsuarioDAO.deleteById(id);
    }
}
