package com.example.tienda.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "idVenta")
    private Long id;



    //ESTE ES EL QUE FUNCIONA HASTA AHORA

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "nombre")
    private Producto nombre = this.getNombre();





    /*

    NO FUNCIONAN ESTAS RELACIONES
    //Prueba
     @ManyToOne
    @JsonIgnoreProperties("ventas")
    private Cliente cliente;

    //Prueba
    @ManyToOne
    @JsonIgnoreProperties("ventas")
    private Categoria categoria;

    //Prueba
    @ManyToOne
    @JsonIgnoreProperties("ventas")
    private Producto producto;

    */

}
