package com.example.proyectofinal_intefaz.model;

// Clase Dispositivo
import java.time.LocalDate;
import java.util.Date;

public class Dispositivo {
    private String identificador;
    private LocalDate fechaCompra;
    private double precio;
    private TipoAtributo tipoAtributo;
    private String marca;
    private String modelo;

    public Dispositivo(String identificador, LocalDate fechaCompra, double precio, TipoAtributo tipoAtributo, String marca, String modelo) {
        this.identificador = identificador;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }



    // Métodos getters y setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoAtributo getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(TipoAtributo tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "identificador=" + identificador +
                ", fechaCompra=" + fechaCompra +
                ", precio=" + precio +
                ", tipoAtributo=" + tipoAtributo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
