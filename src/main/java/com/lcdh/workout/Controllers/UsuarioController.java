package com.lcdh.workout.Controllers;

import com.lcdh.workout.Controllers.DTO.UsuarioDTO;
import com.lcdh.workout.Models.Usuario;
import com.lcdh.workout.Services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usr")
public class UsuarioController {
    @Autowired
   private IUsuarioService iUsuarioService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = iUsuarioService.findById(id);
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
        List<UsuarioDTO> usuarioDTOList = iUsuarioService.findAll().stream()
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId()).nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .edad(usuario.getEdad())
                        .tiempoCarrera(usuario.getTiempoCarrera())
                        .dominadas(usuario.getDominadas())
                        .lagartijas(usuario.getLagartijas()).build()).toList();
        return ResponseEntity.ok(usuarioDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        if (usuarioDTO.getNombre().isBlank() || usuarioDTO.getApellido() == null || usuarioDTO.getEdad() == null) {
            return ResponseEntity.badRequest().build();
        }
        iUsuarioService.save(Usuario.builder().nombre(usuarioDTO.getNombre()).apellido(usuarioDTO.getApellido())
                .edad(usuarioDTO.getEdad()).tiempoCarrera(usuarioDTO.getTiempoCarrera()
                ).lagartijas(usuarioDTO.getLagartijas()).dominadas(usuarioDTO.getDominadas()).build());

        return ResponseEntity.created(new URI("/api/usr/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = iUsuarioService.findById(id);

        if (optionalUsuario.isPresent()) {

            Usuario usuario = optionalUsuario.get();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setEdad(usuarioDTO.getEdad());
            usuario.setTiempoCarrera(usuarioDTO.getTiempoCarrera());
            usuario.setDominadas(usuarioDTO.getDominadas());
            usuario.setLagartijas(usuarioDTO.getLagartijas());
            iUsuarioService.save(usuario);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            iUsuarioService.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado");
        }

        else return ResponseEntity.notFound().build();


    }


}
