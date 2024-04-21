package com.lcdh.workout.Controllers;

import com.lcdh.workout.DTO.UsuarioDTO;
import com.lcdh.workout.Models.Usuario;
import com.lcdh.workout.Services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usr")
public class UsuarioController {
   private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                    .id(usuario.getId())
                    .nombre(usuario.getNombre())
                    .apellido(usuario.getApellido())
                    .edad(usuario.getEdad())
                    .tiempoCarrera(usuario.getTiempoCarrera())
                    .dominadas(usuario.getDominadas())
                    .lagartijas(usuario.getLagartijas()).build();

            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<UsuarioDTO> usuarioDTOList = usuarioService.findAll().stream()
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId()).nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .edad(String.valueOf(usuario.getEdad()))
                        .tiempoCarrera(usuario.getTiempoCarrera())
                        .dominadas(usuario.getDominadas())
                        .lagartijas(usuario.getLagartijas()).build()).toList();
        return ResponseEntity.ok(usuarioDTOList);
    }



    @PostMapping ("/save")

    public ResponseEntity<?> save(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        if (usuarioDTO !=null) {
            usuarioService.save(Usuario.builder().nombre(usuarioDTO.getNombre()).apellido(usuarioDTO.getApellido())
                    .edad((usuarioDTO.getEdad())).tiempoCarrera(usuarioDTO.getTiempoCarrera()
                    ).lagartijas(usuarioDTO.getLagartijas()).dominadas(usuarioDTO.getDominadas()).build());

            return ResponseEntity.created(new URI("/api/usr/save")).build();



        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);

        if (optionalUsuario.isPresent()) {

            Usuario usuario = optionalUsuario.get();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setEdad((usuarioDTO.getEdad()));
            usuario.setTiempoCarrera(usuarioDTO.getTiempoCarrera());
            usuario.setDominadas(usuarioDTO.getDominadas());
            usuario.setLagartijas(usuarioDTO.getLagartijas());
            usuarioService.save(usuario);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);

        if (optionalUsuario.isPresent()){
        usuarioService.deleteById(id);
        return ResponseEntity.ok("usuario eliminado");
        }
        else return ResponseEntity.notFound().build();
    }

    /*public ResponseEntity<?> deleteById( @PathVariable Long id) {

        if (id !=null){
            usuarioService.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado");

        }
        return ResponseEntity.notFound().build();

    }*/


}
