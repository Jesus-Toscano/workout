package com.lcdh.workout.Controllers.DTO;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO  {


    private Long id;
    private String nombre;
    private String apellido;
    private String edad;
    private BigDecimal tiempoCarrera;
    private int dominadas;
    private int lagartijas;

}
