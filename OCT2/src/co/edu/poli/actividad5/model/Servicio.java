package co.edu.poli.actividad5.model;

public class Servicio extends ActividadTuristica {

    private String idServicio;
    private String transporte;
    private String alojamiento;

    /**
     * Constructor por defecto
     */
    public Servicio() {
    }

    /**
    * Constructor con parámetros
    */
    public Servicio(String idServicio, String transporte, String alojamiento) {
    super();
    this.idServicio = idServicio;
    this.transporte = transporte;
    this.alojamiento = alojamiento;
    
    }


    // Getters y Setters
    public String getIdServicio() {
    return idServicio;
    }


    public void setIdServicio(String idServicio) {
    this.idServicio = idServicio;
    }


    public String getTransporte() {
    return transporte;
    }


    public void setTransporte(String transporte) {
    this.transporte = transporte;
    }


    public String getAlojamiento() {
    return alojamiento;
    }


    public void setAlojamiento(String alojamiento) {
    this.alojamiento = alojamiento;
    }
   

    // Métodos de negocio
    protected int calcularCosto() {
    return getPrecio(); // usa el precio heredado
    }


    protected int calcularCosto(int descuento) {
    return getPrecio() - descuento;
    }


    @Override
    public String toString() {
    return "Servicio [idServicio=" + idServicio +
    ", transporte=" + transporte +
    ", alojamiento=" + alojamiento +
    ", costo=" + calcularCosto() +
    ", tiempo=" + getTiempo() +
    ", clima=" + getClima() +
    ", idActividad=" + getIdActividad() +
    ", precio=" + getPrecio() +
    ", tipo=" + getTipo() +
    ", anioActividad=" + getAnioActividad() + "]";
    }
	}
    