package co.edu.poli.parcial.model;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String paisOrigen;
    private String nombre;
    
    public Proveedor(int id, String paisOrigen, String nombre) {
        this.id = id;
        this.paisOrigen = paisOrigen;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Proveedor{id=" + id + ", paisOrigen='" + paisOrigen + "', nombre='" + nombre + "'}";
    }
}