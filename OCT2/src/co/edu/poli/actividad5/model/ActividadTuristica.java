package co.edu.poli.actividad5.model;

/**
 * Representa una actividad turÃ­stica en un destino.
 */
public class ActividadTuristica {

    private String lugar;
    private String tiempo;
    private String clima;
    private String idActividad;
    private int precio; 
    private String tipo;
    private int anioActividad;

    // Constructor por defecto
    public ActividadTuristica() {
    }

 // Getters y Setters
    public void setLugar(String lugar) {
    this.lugar = lugar;
    }


    public String getTiempo() {
    return tiempo;
    }


    public void setTiempo(String tiempo) {
    this.tiempo = tiempo;
    }


    public String getClima() {
    return clima;
    }


    public void setClima(String clima) {
    this.clima = clima;
    }


    public String getIdActividad() {
    return idActividad;
    }


    public void setIdActividad(String idActividad) {
    this.idActividad = idActividad;
    }


    public int getPrecio() {
    return precio;
    }


    public void setPrecio(int precio) {
    // Evitar precios negativos
    if (precio >= 0) {
    this.precio = precio;
    }
    }


    public String getTipo() {
    return tipo;
    }


    public void setTipo(String tipo) {
    this.tipo = tipo;
    }


    public int getAnioActividad() {
    return anioActividad;
    }


    public void setAnioActividad(int anioActividad) {
    // Validar año positivo
    if (anioActividad > 0) {
    this.anioActividad = anioActividad;
    }
    }


    @Override
    public String toString() {
    return "ActividadTuristica [lugar=" + lugar + ", tiempo=" + tiempo +
    ", clima=" + clima + ", idActividad=" + idActividad +
    ", precio=" + precio + ", tipo=" + tipo +
    ", anioActividad=" + anioActividad + "]";
     }
    }