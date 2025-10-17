package co.edu.poli.parcial.model;

import java.io.Serializable;

public class Electronico implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int garantiaMeses;
    
    public Electronico(int codigo, String nombre, double precio, Proveedor proveedor, int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
    
    public int getGarantiaMeses() {
        return garantiaMeses;
    }
    
    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
    
    public String getTipo() {
        return "ELECTRONICO";
    }
    
    @Override
    public String toString() {
        return "Electronico{garantiaMeses=" + garantiaMeses + "}";
    }
}