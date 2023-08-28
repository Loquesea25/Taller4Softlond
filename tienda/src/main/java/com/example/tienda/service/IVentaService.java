package com.example.tienda.service;

import com.example.tienda.entities.Cliente;
import com.example.tienda.entities.Venta;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IVentaService {

    public List<Venta> mostrarVentaPorFecha(Date fechaVenta);
    public List<Venta> mostrarVentaPorCliente(Cliente cliente);
    public List<Venta> mostrarVentaPorClienteRangoFecha(Cliente cliente, Date fechaInicio, Date fechaFin);

    public Venta crearVenta(Venta venta);
    public List<Venta> mostrarVentas();


    public Venta procesarVenta(Venta venta);

    BigDecimal calcularTotalCompras31Dias(Long idCliente);

}
