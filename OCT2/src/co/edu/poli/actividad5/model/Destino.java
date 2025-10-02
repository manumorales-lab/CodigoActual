package co.edu.poli.actividad5.model;

/**
 * Representa un destino turístico con información sobre lugar,
 * nombre, ubicación, cultura e identificador único.
 */
public class Destino {

    private String lugar;
    private String nombre;
    private String ubicacion;
    private String cultura;
    private String idDestino;

    /**
     * Constructor por defecto
     */
    public Destino() {
    }

    /**
    * Constructor con par�metros
    */
    public Destino(String lugar, String nombre, String ubicacion, String cultura, String idDestino) {
    this.lugar = lugar;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.cultura = cultura;
    this.idDestino = idDestino;
    }
    // Getters y Setters
    public String getLugar() {
    return lugar;
    }
    public void setLugar(String lugar) {
    this.lugar = lugar;
    }
    public String getNombre() {
    return nombre;
    }
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    public String getUbicacion() {
    return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
    }
    public String getCultura() {
    return cultura;
    }
    public void setCultura(String cultura) {
    this.cultura = cultura;
    }
    public String getIdDestino() {
    return idDestino;
    }
    public void setIdDestino(String idDestino) {
    this.idDestino = idDestino;
    }
    @Override
    public String toString() {
    return "Destino [lugar=" + lugar +
    ", nombre=" + nombre +
    ", ubicacion=" + ubicacion +
    ", cultura=" + cultura +
    ", idDestino=" + idDestino + "]";
   }
  }