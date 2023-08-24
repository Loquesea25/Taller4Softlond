package com.example.tienda.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "idCliente")
    private Long idCliente;
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Column(name = "apellidoCliente")
    private String apellidoCliente;
    @Column(name = "telefonoCliente")
    private String telefonoCliente;
    @Column(name = "emailCliente")
    private String emailCliente;


    @OneToMany
    @JoinColumn(name = "idCliente")
    private List<Venta> ventas;


}
