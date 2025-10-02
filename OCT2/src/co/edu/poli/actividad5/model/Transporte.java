package co.edu.poli.actividad5.model;

/**
 * Representa un medio de transporte tur√≠stico.
 */
public class Transporte {

    private String serial;
    private int capacidad;
    private int precio;      // precio por unidad (ejemplo: por km o por persona)
    private String tipo;
    private int distancia;   // distancia a recorrer

    // Constructor por defecto
    public Transporte() {
    }

 // Constructor con par·metros
    public Transporte(String serial, int capacidad, int precio, String tipo, int distancia) {
    this.serial = serial;
    this.capacidad = capacidad;
    this.precio = precio;
    this.tipo = tipo;
    this.distancia = distancia;
    }


    // Getters y Setters
    public String getSerial() {
    return serial;
    }


    public void setSerial(String serial) {
    this.serial = serial;
    }


    public int getCapacidad() {
    return capacidad;
    }


    public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
    }


    public int getPrecio() {
    return precio;
    }


    public void setPrecio(int precio) {
    this.precio = precio;
    }


    public String getTipo() {
    return tipo;
    }


    public void setTipo(String tipo) {
    this.tipo = tipo;
    }


    public int getDistancia() {
    return distancia;
    }


    public void setDistancia(int distancia) {
    this.distancia = distancia;
    }


    // MÈtodo de negocio
    public int calcularCostoTotal() {
    return precio * distancia;
    }


    @Override
    public String toString() {
    return "Transporte [serial=" + serial +
    ", capacidad=" + capacidad +
    ", precio=" + precio +
    ", tipo=" + tipo +
    ", distancia=" + distancia +
    ", costoTotal=" + calcularCostoTotal() + "]";
    }
   }