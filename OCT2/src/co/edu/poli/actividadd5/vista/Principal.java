package co.edu.poli.actividadd5.vista;

import java.util.Scanner;

import co.edu.poli.actividad5.model.ActividadTuristica;
import co.edu.poli.actividad5.servicios.*;

public class Principal {

    private static ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ActividadTuristica[] actividades = serydes.leerDeArchivo();
        // Cargamos lo le�do en el CRUD
        for (ActividadTuristica a : actividades) {
            if (a != null) {
                crud.create(a);
            }
        }

        int opcion;
        do {
            System.out.println("\n===== MEN� PRINCIPAL =====");
            System.out.println("1. Crear Actividad Tur�stica");
            System.out.println("2. Listar todas las Actividades");
            System.out.println("3. Listar una Actividad por ID");
            System.out.println("4. Guardar en Archivo");
            System.out.println("5. Cargar desde Archivo");
            System.out.println("6. Modificar Actividad");
            System.out.println("7. Eliminar Actividad");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opci�n: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> crearActividad();
                case 2 -> listarTodas();
                case 3 -> listarUna();
                case 4 -> guardarArchivo();
                case 5 -> cargarArchivo();
                case 6 -> modificarActividad();
                case 7 -> eliminarActividad();
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opci�n inv�lida, intente de nuevo.");
            }
        } while (opcion != 8);
    }

    private static void crearActividad() {
        if (crud.listAll().length >= 10) {
            System.out.println(" No se pueden guardar m�s de 10 actividades.");
            return;
        }

        System.out.print("Ingrese ID: ");
        String id = sc.nextLine();
        System.out.print("Ingrese lugar: ");
        String lugar = sc.nextLine();
        System.out.print("Ingrese tiempo: ");
        String tiempo = sc.nextLine();
        System.out.print("Ingrese clima: ");
        String clima = sc.nextLine();
        System.out.print("Ingrese precio: ");
        int precio = sc.nextInt();
        System.out.print("Ingrese a�o: ");
        int anio = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese tipo: ");
        String tipo = sc.nextLine();

        ActividadTuristica act = new ActividadTuristica(lugar, tiempo, clima, id, precio, tipo, anio);
        if (crud.create(act)) {
            System.out.println("Actividad creada exitosamente.");
        } else {
            System.out.println("No se pudo crear la actividad (ID duplicado o espacio insuficiente).");
        }
    }

    private static void listarTodas() {
        System.out.println("\n=== LISTADO DE ACTIVIDADES ===");
        for (ActividadTuristica a : crud.listAll()) {
            if (a != null) {
                System.out.println(a);
            }
        }
    }

    private static void listarUna() {
        System.out.print("Ingrese ID de la actividad: ");
        String id = sc.nextLine();
        ActividadTuristica act = crud.read(id);
        if (act != null) {
            System.out.println("Actividad encontrada: " + act);
        } else {
            System.out.println("Actividad no encontrada.");
        }
    }

    private static void guardarArchivo() {
        serydes.guardarEnArchivo(crud.listAll());
    }

    private static void cargarArchivo() {
        ActividadTuristica[] actividades = serydes.leerDeArchivo();
        for (ActividadTuristica a : actividades) {
            if (a != null) {
                crud.create(a);
            }
        }
    }

    private static void modificarActividad() {
        System.out.print("Ingrese ID de la actividad a modificar: ");
        String id = sc.nextLine();
        ActividadTuristica existente = crud.read(id);
        if (existente == null) {
            System.out.println("Actividad no encontrada.");
            return;
        }

        System.out.print("Nuevo lugar: ");
        String lugar = sc.nextLine();
        System.out.print("Nuevo tiempo: ");
        String tiempo = sc.nextLine();
        System.out.print("Nuevo clima: ");
        String clima = sc.nextLine();
        System.out.print("Nuevo precio: ");
        int precio = sc.nextInt();
        System.out.print("Nuevo a�o: ");
        int anio = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo tipo: ");
        String tipo = sc.nextLine();

        ActividadTuristica nueva = new ActividadTuristica(lugar, tiempo, clima, id, precio, tipo, anio);
        if (crud.update(id, nueva)) {
            System.out.println("Actividad modificada correctamente.");
        } else {
            System.out.println("Error al modificar la actividad.");
        }
    }

    private static void eliminarActividad() {
        System.out.print("Ingrese ID de la actividad a eliminar: ");
        String id = sc.nextLine();
        if (crud.delete(id)) {
            System.out.println("Actividad eliminada.");
        } else {
            System.out.println("No se pudo eliminar (ID no encontrado).");
        }
    }
}
