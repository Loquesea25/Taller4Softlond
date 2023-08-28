package com.example.tienda.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
    @Column(name = "precio_total")
    private BigDecimal precioTotal;
    @Column(name = "precio_total_con_descuento")
    private BigDecimal precioTotalConDescuento;
    @Column(name = "nombre_producto")
    private String nombre;



    //ESTE ES EL QUE FUNCIONA HASTA AHORA

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto idProducto;





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
