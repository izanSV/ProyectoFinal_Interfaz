package com.example.proyectofinal_intefaz.model;




import java.time.LocalDate;

/**
 * Clase que representa un dispositivo.
 */
public class Dispositivo {
    private String identificador;
    private LocalDate fechaCompra;
    private double precio;
    private TipoAtributo tipoAtributo;
    private String marca;
    private String modelo;

    /**
     * Constructor de la clase Dispositivo.
     *
     * @param identificador El identificador del dispositivo.
     * @param fechaCompra   La fecha de compra del dispositivo.
     * @param precio        El precio del dispositivo.
     * @param tipoAtributo  El tipo de atributo del dispositivo.
     * @param marca         La marca del dispositivo.
     * @param modelo        El modelo del dispositivo.
     */
    public Dispositivo(String identificador, LocalDate fechaCompra, double precio, TipoAtributo tipoAtributo, String marca, String modelo) {
        this.identificador = identificador;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Obtiene el identificador del dispositivo.
     *
     * @return El identificador del dispositivo.
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador del dispositivo.
     *
     * @param identificador El identificador a establecer.
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtiene la fecha de compra del dispositivo.
     *
     * @return La fecha de compra del dispositivo.
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Establece la fecha de compra del dispositivo.
     *
     * @param fechaCompra La fecha de compra a establecer.
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Obtiene el precio del dispositivo.
     *
     * @return El precio del dispositivo.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del dispositivo.
     *
     * @param precio El precio a establecer.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el tipo de atributo del dispositivo.
     *
     * @return El tipo de atributo del dispositivo.
     */
    public TipoAtributo getTipoAtributo() {
        return tipoAtributo;
    }

    /**
     * Establece el tipo de atributo del dispositivo.
     *
     * @param tipoAtributo El tipo de atributo a establecer.
     */
    public void setTipoAtributo(TipoAtributo tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    /**
     * Obtiene la marca del dispositivo.
     *
     * @return La marca del dispositivo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del dispositivo.
     *
     * @param marca La marca a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del dispositivo.
     *
     * @return El modelo del dispositivo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del dispositivo.
     *
     * @param modelo El modelo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve una representación en formato de cadena de la instancia de Dispositivo.
     *
     * @return Cadena que representa la instancia de Dispositivo.
     */
    @Override
    public String toString() {
        return "Dispositivo{" +
                "identificador='" + identificador + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", precio=" + precio +
                ", tipoAtributo=" + tipoAtributo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
