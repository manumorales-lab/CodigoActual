package co.edu.poli.actividad5.model;
public class Actividad {
private String tipo;
private int precio;
private int duracion;
private int capacidad;
private String fecha;
private String idActividad;
public Actividad() {
}
public Actividad(String tipo, int precio, int duracion, int capacidad, String fecha, String idActividad) {
this.tipo = tipo;
this.precio = precio;
this.duracion = duracion;
this.capacidad = capacidad;
this.fecha = fecha;
this.idActividad = idActividad;
}
public String getTipo() {
return tipo;
}


public void setTipo(String tipo) {
this.tipo = tipo;
}


public int getPrecio() {
return precio;
}


public void setPrecio(int precio) {
if (precio >= 0) {
this.precio = precio;
}
}


public int getDuracion() {
return duracion;
}


public void setDuracion(int duracion) {
if (duracion > 0) {
this.duracion = duracion;
}
}


public int getCapacidad() {
return capacidad;
}


public void setCapacidad(int capacidad) {
if (capacidad >= 0) {
this.capacidad = capacidad;
}
}


public String getFecha() {
return fecha;
}


public void setFecha(String fecha) {
this.fecha = fecha;
}


public String getIdActividad() {
return idActividad;
}


public void setIdActividad(String idActividad) {
this.idActividad = idActividad;
}
@Override
public String toString() {
return "Actividad [tipo=" + tipo + ", precio=" + precio + ", duracion=" + duracion +
", capacidad=" + capacidad + ", fecha=" + fecha + ", idActividad=" + idActividad + "]";
 }
}