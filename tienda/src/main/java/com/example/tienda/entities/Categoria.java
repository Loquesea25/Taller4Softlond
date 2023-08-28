package com.example.tienda.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "idCategoria")
    private Long idCategoria;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    /*
    @ManyToMany(mappedBy = "idCategoria")
    private List<Producto> productos;
    NO ES NECESARIO.
     */

    /*
    //Prueba
    @OneToMany(mappedBy = "categoria")
    private List<Venta> ventas;
     */

}
