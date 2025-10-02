package co.edu.poli.actividad5.model;

/**
 * Representa un cliente con datos básicos como id, edad,
 * nombre y si cuenta con seguro médico.
 */
public class Cliente {

    private String idCliente;
    private int edad;
    private String nombre;
    private boolean seguroMedico;

    /**
     * Constructor por defecto
     */
    public Cliente() {
    }

    public Cliente(String idCliente, int edad, String nombre, boolean seguroMedico) {
    	this.idCliente = idCliente;
    	setEdad(edad);
    	this.nombre = nombre;
    	this.seguroMedico = seguroMedico;
    	}
  	public String getIdCliente() {
   return idCliente;
    }
    public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
    }
   public int getEdad() {
   return edad;
    }
   public void setEdad(int edad) {
   if (edad >= 0) {
   this.edad = edad;
   }
   }
   public String getNombre() {
   return nombre;
    }
   public void setNombre(String nombre) {
   this.nombre = nombre;
  	}
   public boolean isSeguroMedico() {
   return seguroMedico;
   }
   public void setSeguroMedico(boolean seguroMedico) {
   this.seguroMedico = seguroMedico;
   }
  @Override
  public String toString() {
  return "Cliente [idCliente=" + idCliente +
 ", edad=" + edad +
   ", nombre=" + nombre +
  ", seguroMedico=" + seguroMedico + "]";
    }
   }