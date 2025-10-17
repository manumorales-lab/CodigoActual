package co.edu.poli.parcial.model;

public class Electronico {
    private int garantiaMeses;
    
    public Electronico(int codigo, String nombre, double precio, Proveedor proveedor, int garantiaMeses) {
        // Nota: Este constructor no coincide con Producto, se mantiene como en el diagrama
        this.garantiaMeses = garantiaMeses;
    }
    
    public int getGarantiaMeses() {
        return garantiaMeses;
    }
    
    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
    
    public String getTipo() {
        return "Electronico";
    }
    
    @Override
    public String toString() {
        return "Electronico{garantiaMeses=" + garantiaMeses + "}";
    }
}