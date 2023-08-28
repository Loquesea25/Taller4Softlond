
package com.example.tienda.controller;

import com.example.tienda.entities.Cliente;
import com.example.tienda.entities.Venta;
import com.example.tienda.service.IClienteService;
import com.example.tienda.service.VentaServiceIMPL;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/venta")
public class VentaController {
    @Autowired
    private VentaServiceIMPL ventaServiceIMPL;
    @Autowired
    private IClienteService iClienteService;

    @GetMapping
    @RequestMapping(value = "mostrarVentas", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarVentas(){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            List listaVentas = this.ventaServiceIMPL.mostrarVentas();
            return ResponseEntity.ok().body(listaVentas);
        }catch (Exception e){
            logger.error("Ocurrió un problema al mostrar las ventas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un problema al mostrar las ventas"));
        }
    }


    @GetMapping
    @RequestMapping(value = "mostrarVentaPorFecha", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarVentaPorFecha(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        Logger logger = LoggerFactory.getLogger(getClass());
        try {
            List<Venta> ventaPorFecha = this.ventaServiceIMPL.mostrarVentaPorFecha(fecha);
            return ResponseEntity.ok().body(ventaPorFecha);
        } catch (Exception e) {
            logger.error("Ocurrió un error al mostrar las ventas por fecha");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un error al mostrar las ventas por fecha"));
        }
    }

    @GetMapping
    @RequestMapping(value = "mostrarVentaPorCliente", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarVentaPorCliente(@RequestParam("clienteId") Long clienteId) {
        Logger logger = LoggerFactory.getLogger(getClass());
        try {
            Cliente cliente = this.iClienteService.buscarClientePorId(clienteId);
            List<Venta> listaVentaPorCliente = this.ventaServiceIMPL.mostrarVentaPorCliente(cliente);
            return ResponseEntity.ok().body(listaVentaPorCliente);
        } catch (Exception e) {
            logger.error("Ocurrió un error al mostrar las ventas por cliente");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un error al mostrar las ventas por cliente"));
        }
    }

    @GetMapping
    @RequestMapping(value = "mostrarVentaPorClienteRangoFecha", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarVentaPorClienteRangoFecha(@RequestParam("clienteId") Long clienteId, @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        Logger logger = LoggerFactory.getLogger(getClass());
        try {
            Cliente cliente = this.iClienteService.buscarClientePorId(clienteId);
            List<Venta> listaVentaClienteRangoFecha = this.ventaServiceIMPL.mostrarVentaPorClienteRangoFecha(cliente, fechaInicio, fechaFin);
            return ResponseEntity.ok().body(listaVentaClienteRangoFecha);
        } catch (Exception e) {
            logger.error("Ocurrió un error al mostrar las ventas por cliente y rango de fecha");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un error al mostrar las ventas por cliente y rango de fecha"));
        }
    }


    @PostMapping
    @RequestMapping(value = "crearVenta", method = RequestMethod.POST)
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta){
        Logger logger = LoggerFactory.getLogger(getClass());
        try {
            Venta ventaCreada = this.ventaServiceIMPL.crearVenta(venta);
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaCreada);
        }catch (Exception e){
            logger.error("Ocurrió un error al crear la venta");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Venta) Collections.singletonList("Ocurrió un error al crear la venta"));
        }
    }
    /*

    @PostMapping
    @RequestMapping(value = "registrarVenta")
    public ResponseEntity<String> registrarVenta(@RequestBody VentaRequest ventaRequest) {
        // Validar y procesar los datos de venta
        double montoTotal = calcularMontoTotal(ventaRequest);

        // Verificar si el cliente cumple con los requisitos para el descuento
        boolean cumpleRequisitosDescuento = clienteCumpleRequisitosParaDescuento(ventaRequest.getCliente(), montoTotal);

        // Aplicar el descuento si es necesario
        if (cumpleRequisitosDescuento) {
            montoTotal -= (montoTotal * porcentajeDescuento / 100.0);
        }

        // Registrar la venta (puedes adaptar esto según tus necesidades, como guardar en una base de datos)
        // En este ejemplo, simplemente devolvemos una respuesta con el monto total final
        return ResponseEntity.ok("Monto total de la venta: " + montoTotal);
    }

    private double calcularMontoTotal(VentaRequest ventaRequest) {
        // Obtén los detalles de la venta (productos y cantidades) desde la solicitud
        List<DetalleVenta> detallesVenta = ventaRequest.getDetallesVenta();

        if (detallesVenta == null || detallesVenta.isEmpty()) {
            return 0.0; // Si no hay detalles de venta, el monto total es cero.
        }

        // Itera a través de los detalles de venta y calcula el monto total
        double montoTotal = 0.0;
        for (DetalleVenta detalle : detallesVenta) {
            // Supongamos que cada detalle tiene un precio y una cantidad
            double precio = detalle.getPrecio();
            int cantidad = detalle.getCantidad();
            montoTotal += precio * cantidad;
        }

        return montoTotal;
    }

    private boolean clienteCumpleRequisitosParaDescuento(String clienteId, double montoTotal) {
        // Obtén información sobre el cliente y su historial de compras
        Cliente cliente = clienteService.obtenerClientePorId(clienteId);
        List<Compra> historialCompras = clienteService.obtenerHistorialComprasCliente(cliente);

        // Implementa la lógica para verificar los requisitos
        if (cliente == null || historialCompras.isEmpty()) {
            return false; // No cumple si no hay información del cliente o historial de compras.
        }
        double totalGastadoUltimos31Dias = calcularTotalGastadoUltimos31Dias(historialCompras);

        // Verifica si el cliente ha gastado más de 1 millón en los últimos 31 días
        return totalGastadoUltimos31Dias > 1000000.0;

     */
}


