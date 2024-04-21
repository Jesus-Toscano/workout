package com.lcdh.workout.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO  {


    private Long id;
    @NotEmpty(message = "Registra un nombre")
    private String nombre;
    @NotEmpty(message = "Registra un apellido")
    private String apellido;
    @NotEmpty(message = "Registra una edad")
    private String edad;
    private Double tiempoCarrera;
    private int dominadas;
    private int lagartijas;

}
