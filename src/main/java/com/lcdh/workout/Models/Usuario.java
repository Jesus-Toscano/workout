package com.lcdh.workout.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Collate;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GeneratedColumn;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name ="Atletas")

public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String edad;
    @Column
    private Double tiempoCarrera;
    @Column
    private int dominadas;
    @Column
    private int lagartijas;
    @Column
    private String direccion;
    @Column
    private String numTelefono;

}
