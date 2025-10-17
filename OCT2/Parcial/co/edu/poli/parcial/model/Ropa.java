package co.edu.poli.parcial.model;

import java.io.Serializable;

public class Ropa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String talla;
    
    public Ropa(int codigo, String nombre, double precio, int stock, Proveedor proveedor, String talla) {
        this.talla = talla;
    }
    
    public String getTalla() {
        return talla;
    }
    
    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    public String getTipo() {
        return "ROPA";
    }
    
    @Override
    public String toString() {
        return "Ropa{talla='" + talla + "'}";
    }
}