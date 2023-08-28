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
    @Column(name = "nombreCliente", nullable = false)
    private String nombreCliente;
    @Column(name = "apellidoCliente", nullable = false)
    private String apellidoCliente;
    @Column(name = "telefonoCliente", nullable = false)
    private String telefonoCliente;
    @Column(name = "emailCliente", nullable = false, unique = true)
    private String emailCliente;


    /*
    //Prueba
    @OneToMany
    @JoinColumn(name = "idClienteVenta")
    private List<Venta> ventas;


     */

}
