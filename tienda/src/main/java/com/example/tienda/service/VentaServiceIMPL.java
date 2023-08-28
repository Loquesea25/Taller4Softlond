package com.example.tienda.service;

import com.example.tienda.entities.Cliente;
import com.example.tienda.entities.Venta;
import com.example.tienda.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class VentaServiceIMPL implements IVentaService{
    @Autowired
    private IVentaRepository iVentaRepository;


    @Override
    public List<Venta> mostrarVentaPorFecha(Date fechaVenta) {
        return (List<Venta>) this.iVentaRepository.findAll();
    }

    @Override
    public List<Venta> mostrarVentaPorCliente(Cliente cliente) {
        return (List<Venta>) this.iVentaRepository.findAll();
    }

    @Override
    public List<Venta> mostrarVentaPorClienteRangoFecha(Cliente cliente, Date fechaInicio, Date fechaFin) {
        return (List<Venta>) this.iVentaRepository.findAll();
    }


    @Override
    public Venta crearVenta(Venta venta) {
        venta.setCliente(venta.getCliente());
        return this.iVentaRepository.save(venta);
    }

    @Override
    public List<Venta> mostrarVentas() {
        return (List<Venta>) this.iVentaRepository.findAll();
    }


    public BigDecimal obtenerPorcentajeDescuento() {
        return new BigDecimal("10");
    }

    @Override
    public BigDecimal calcularTotalCompras31Dias(Long idCliente) {
        return null;
    }

    @Override
    public Venta procesarVenta(Venta venta) {
        BigDecimal totalCompras31Dias = calcularTotalCompras31Dias(venta.getCliente().getIdCliente());


        if (totalCompras31Dias.compareTo(new BigDecimal("1000000")) >= 0) {

            BigDecimal porcentajeDescuento = obtenerPorcentajeDescuento();
            BigDecimal precioConDescuento = venta.getPrecioTotal().subtract(venta.getPrecioTotal().multiply(porcentajeDescuento.divide(new BigDecimal("100"))));
            venta.setPrecioTotalConDescuento(precioConDescuento);
        }

        return iVentaRepository.save(venta);
    }




}
