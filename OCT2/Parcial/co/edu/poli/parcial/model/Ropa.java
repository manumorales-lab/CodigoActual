package co.edu.poli.parcial.model;

public class Ropa {
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
        return "Ropa";
    }
    
    @Override
    public String toString() {
        return "Ropa{talla='" + talla + "'}";
    }
}