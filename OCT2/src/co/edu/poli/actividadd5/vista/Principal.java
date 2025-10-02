package co.edu.poli.actividadd5.vista;


import co.edu.poli.actividad5.model.*;
import co.edu.poli.actividad5.servicios.*;

/**
 * 
 */
public class Principal {


public static void main(String[] args) {
	// Crear un Cliente
	Cliente cliente1 = new Cliente("C001", 25, "Juan Pérez", true);
	System.out.println(cliente1);


	// Crear un Destino
	Destino destino1 = new Destino("Cartagena", "Playa Blanca", "Bolívar", "Caribeña", "D001");
	System.out.println(destino1);


	// Crear una Actividad
	Actividad actividad1 = new Actividad("Deporte acuático", 100000, 2, 10, "2025-12-10", "A001");
	System.out.println(actividad1);


	// Crear una Actividad Turística
	/*
	ActividadTuristica actTuristica1 = new ActividadTuristica(
	"Santa Marta", "3 horas", "Soleado", "AT001",
	80000, "Excursión", 2025);
	System.out.println(actTuristica1);
*/

	// Crear un Alojamiento
	Alojamiento hotel1 = new Alojamiento(300000, 2, "Cartagena Centro", "H001", "Hotel Mar Azul", 3);
	System.out.println(hotel1);


	// Crear un Transporte
	Transporte bus1 = new Transporte("T001", 40, 50000, "Bus turístico", 300);
	System.out.println(bus1);


	// Crear un Transporte Marítimo
	TransporteMaritimo barco1 = new TransporteMaritimo(500, "Puerto de Barranquilla");
	System.out.println(barco1);
	// Crear un Servicio (que hereda de ActividadTuristica)
	Servicio servicio1 = new Servicio("S001", "Bus", "Hotel Mar Azul");
	servicio1.setLugar("Cartagena");
	servicio1.setTiempo("4 horas");
	servicio1.setClima("Soleado");
	servicio1.setIdActividad("SV001");
	servicio1.setPrecio(150000);
	servicio1.setTipo("Tour completo");
	servicio1.setAnioActividad(2025);
	System.out.println(servicio1);


	// Crear una Calificación
	Calificacion calificacion1 = new Calificacion(5, "CAL001", "Excelente experiencia, muy recomendado.");
	System.out.println(calificacion1);


	System.out.println("\n=== Fin de la demostración ===");
	}
	}