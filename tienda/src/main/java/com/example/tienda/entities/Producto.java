package com.example.tienda.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "producto")
    public class Producto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Setter(AccessLevel.NONE)
        @Column(name = "idProducto")
        private Long idProducto;
        @Column(name = "nombre")
        private String nombre;
        @Column(name = "precio")
        private double precio;


        @ManyToOne
        @JoinColumn(name = "idCategoria")
        private Categoria idCategoria;


        /*
        //Prueba
         @OneToMany(mappedBy = "producto")
        private List<Venta> ventas;

         */


    }
