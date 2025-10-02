package co.edu.poli.actividad5.model;

public class Calificacion {

    private int puntuacion;
    private String idCalificacion;
    private String comentario;

    
    public Calificacion() {
    }

    public Calificacion(int puntuacion, String idCalificacion, String comentario) {
    	setPuntuacion(puntuacion);
    	this.idCalificacion = idCalificacion;
    	this.comentario = comentario;
    	}


    	public int getPuntuacion() {
    	return puntuacion;
    	}


    	public void setPuntuacion(int puntuacion) {
    	if (puntuacion >= 0 && puntuacion <= 5) {
    	this.puntuacion = puntuacion;
    	} else {
    	this.puntuacion = 0;
    	}
    	}


    	public String getIdCalificacion() {
    	return idCalificacion;
    	}


    	public void setIdCalificacion(String idCalificacion) {
    	this.idCalificacion = idCalificacion;
    	}


    	public String getComentario() {
    	return comentario;
    	}


    	public void setComentario(String comentario) {
    	this.comentario = comentario;
    	}


    	@Override
    	public String toString() {
    	return "Calificacion [puntuacion=" + puntuacion +
    	", idCalificacion=" + idCalificacion +
    	", comentario=" + comentario + "]";
    	 }
    	}