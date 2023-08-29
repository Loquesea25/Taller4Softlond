package com.example.tienda.controller;

import com.example.tienda.entities.Descuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "api/descuento")
public class DescuentoController {

    private Descuento descuento;
    @GetMapping
    @RequestMapping(value = "opcionesDescuento", method = RequestMethod.GET)
    public String obtenerOpciones() {
        return "Opciones disponibles:\n" +
                "1. El descuento definido por la empresa\n" +
                "2. Un nuevo intento\n" +
                "3. No ganaste";
    }

    @PostMapping
    @RequestMapping(value = "elegirDescuento", method = RequestMethod.POST)
    public String elegirOpcion(@RequestParam int opcion) {

        double porcentajeDescuento = descuento.getPorcentajeDescuento();

        if (descuento.getNumeroIntentos() >= 3) {
            return "Máximo de intentos alcanzado. Gracias por participar.";
        }

        Random random = new Random();

        switch (opcion) {
            case 1:
                porcentajeDescuento = 0.10;
                break;
            case 2:

                porcentajeDescuento = random.nextDouble();
                break;
            case 3:
                porcentajeDescuento = 0.0;
                break;
            default:
                return "Opción no válida. Por favor, elige 1, 2 o 3.";
        }

        double numeroIntentos = descuento.getNumeroIntentos();
        numeroIntentos++;

        return "Descuento aplicado: " + (porcentajeDescuento * 100) + "%";
    }
}
