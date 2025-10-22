package com.cosmotravel.modelo;

import java.time.LocalDate;

public class Alimento {
    private int id;
    private String nombre;
    private String formato;
    private int cantidad;
    private LocalDate fechaCaducidad;

    public Alimento(int id, String nombre, int cantidad, LocalDate fechaCaducidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
        this.formato = "Estándar";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public void setFechaCaducidad(LocalDate fechaCaducidad) { 
        this.fechaCaducidad = fechaCaducidad; 
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | Cant: %d | Cad: %s", 
            id, nombre, formato, cantidad, fechaCaducidad);
    }
}