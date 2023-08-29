package com.example.tienda.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Table(name = "descuento")

public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descuentoId")
    private Long id;
    private double porcentajeDescuento = 0;
    private int numeroIntentos = 0;
}
