package com.example.proyectofinal_intefaz.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Inventario {
    private List<Dispositivo> listaDispositivos;
    private int ordenacion;
    private String rutaImpresion;

    public Inventario() {
        this.listaDispositivos = new ArrayList<>();
        this.ordenacion = 0; // Valor inicial sin ordenar
        this.rutaImpresion = ""; // Ruta por defecto
    }

    public void mostrarDispositivos() {
        for (Dispositivo dispositivo : listaDispositivos) {
            System.out.println("ID: " + dispositivo.getIdentificador() +
                    ", Tipo: " + dispositivo.getTipoAtributo() +
                    ", Marca: " + dispositivo.getMarca() +
                    ", Modelo: " + dispositivo.getModelo() +
                    ", Fecha de compra: " + dispositivo.getFechaCompra());
        }
    }

    public void ordenarDispositivosFecha(int tipoOrdenacion) {
        if (tipoOrdenacion == 1) { // Ascendente
            Collections.sort(listaDispositivos, Comparator.comparing(Dispositivo::getFechaCompra));
        } else if (tipoOrdenacion == 2) { // Descendente
            Collections.sort(listaDispositivos, Comparator.comparing(Dispositivo::getFechaCompra).reversed());
        }
        this.ordenacion = tipoOrdenacion;
    }

}
