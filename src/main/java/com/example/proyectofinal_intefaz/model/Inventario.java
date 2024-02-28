package com.example.proyectofinal_intefaz.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que representa el inventario de dispositivos.
 */
public class Inventario {
    private List<Dispositivo> listaDispositivos;
    private int ordenacion; // 0: Sin orden, 1: Ascendente, 2: Descendente
    private String rutaImpresion; // Ruta para la impresión por defecto

    /**
     * Constructor de la clase Inventario.
     */
    public Inventario() {
        this.listaDispositivos = new ArrayList<>();
        this.ordenacion = 0; // Valor inicial sin ordenar
        this.rutaImpresion = ""; // Ruta por defecto
    }

    /**
     * Método para mostrar los dispositivos del inventario por consola.
     */
    public void mostrarDispositivos() {
        for (Dispositivo dispositivo : listaDispositivos) {
            System.out.println("ID: " + dispositivo.getIdentificador() +
                    ", Tipo: " + dispositivo.getTipoAtributo() +
                    ", Marca: " + dispositivo.getMarca() +
                    ", Modelo: " + dispositivo.getModelo() +
                    ", Fecha de compra: " + dispositivo.getFechaCompra());
        }
    }

    /**
     * Método para ordenar los dispositivos por fecha de compra.
     *
     * @param tipoOrdenacion Tipo de ordenación: 1 para ascendente, 2 para descendente.
     */
    public void ordenarDispositivosFecha(int tipoOrdenacion) {
        if (tipoOrdenacion == 1) { // Ascendente
            Collections.sort(listaDispositivos, Comparator.comparing(Dispositivo::getFechaCompra));
        } else if (tipoOrdenacion == 2) { // Descendente
            Collections.sort(listaDispositivos, Comparator.comparing(Dispositivo::getFechaCompra).reversed());
        }
        this.ordenacion = tipoOrdenacion;
    }

}
