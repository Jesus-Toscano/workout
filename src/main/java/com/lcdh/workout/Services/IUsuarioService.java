package com.lcdh.workout.Services;

import com.lcdh.workout.Models.Usuario;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario>findAll();

    Optional<Usuario>findById(Long id);

    void save (Usuario usuario);

    void deleteById(Long id);

}
