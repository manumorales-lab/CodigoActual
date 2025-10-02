package co.edu.poli.actividad5.model;

public class Alojamiento {

    private int precio;
    private int capacidad;
    private String ubicacion;
    private String idAlojamiento;
    private String nombre;
    private int noches;

    
    public Alojamiento() {
    }
    public Alojamiento(int precio, int capacidad, String ubicacion, String idAlojamiento, String nombre, int noches) {
        this.precio = precio;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.noches = noches;
    }

 // Getters y Setters con validación básica
    public int getPrecio() {
    return precio;
    }


    public void setPrecio(int precio) {
    if (precio >= 0) {
    this.precio = precio;
    }
    }


    public int getCapacidad() {
    return capacidad;
    }


    public void setCapacidad(int capacidad) {
    if (capacidad > 0) {
    this.capacidad = capacidad;
    }
    }


    public String getUbicacion() {
    return ubicacion;
    }


    public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
    }


    public String getIdAlojamiento() {
    return idAlojamiento;
    }


    public void setIdAlojamiento(String idAlojamiento) {
    this.idAlojamiento = idAlojamiento;
    }


    public String getNombre() {
    return nombre;
    }


    public void setNombre(String nombre) {
    this.nombre = nombre;
    }


    public int getNoches() {
    return noches;
    }


    public void setNoches(int noches) {
    if (noches >= 0) {
    this.noches = noches;
    }
    }


    @Override
    public String toString() {
    return "Alojamiento [precio=" + precio + ", capacidad=" + capacidad +
    ", ubicacion=" + ubicacion + ", idAlojamiento=" + idAlojamiento +
    ", nombre=" + nombre + ", noches=" + noches + "]";
     }
    }