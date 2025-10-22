package com.cosmotravel.main;

import com.cosmotravel.service.AlimentoServicio;
import com.cosmotravel.modelo.Alimento;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SistemaAlimentos {
    private AlimentoServicio alimentoServicio;
    private Scanner scanner;

    public static void main(String[] args) {
        SistemaAlimentos sistema = new SistemaAlimentos();
        sistema.ejecutar();
    }

    public void ejecutar() {
        inicializarSistema();
        mostrarMenuPrincipal();
        cerrarSistema();
    }

    private void inicializarSistema() {
        this.alimentoServicio = new AlimentoServicio();
        this.scanner = new Scanner(System.in);
        System.out.println("🚀 SISTEMA COSMOTRAVEL - GESTIÓN DE ALIMENTOS");
        System.out.println("Sistema inicializado correctamente\n");
    }

    private void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear alimento");
            System.out.println("2. Listar alimentos");
            System.out.println("3. Buscar alimento por ID");
            System.out.println("4. Actualizar alimento");
            System.out.println("5. Eliminar alimento");
            System.out.println("6. Serializar datos");
            System.out.println("7. Deserializar datos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción (1-8): ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido");
                opcion = 0;
            }
            
        } while (opcion != 8);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: crearAlimento(); break;
            case 2: listarAlimentos(); break;
            case 3: buscarAlimentoPorId(); break;
            case 4: actualizarAlimento(); break;
            case 5: eliminarAlimento(); break;
            case 6: serializarDatos(); break;
            case 7: deserializarDatos(); break;
            case 8: confirmarSalida(); break;
            default: System.out.println("❌ Opción no válida");
        }
    }

    private void crearAlimento() {
        System.out.println("\n--- CREAR ALIMENTO ---");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("❌ El nombre no puede estar vacío");
            return;
        }
        
        System.out.print("Formato: ");
        String formato = scanner.nextLine();
        if (formato.isEmpty()) formato = "Estándar";
        
        int cantidad = 0;
        try {
            System.out.print("Cantidad: ");
            cantidad = Integer.parseInt(scanner.nextLine());
            if (cantidad <= 0) {
                System.out.println("❌ La cantidad debe ser mayor a 0");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ La cantidad debe ser un número");
            return;
        }
        
        LocalDate fechaCaducidad;
        try {
            System.out.print("Fecha caducidad (YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            fechaCaducidad = LocalDate.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("❌ Error en formato de fecha");
            return;
        }
        
        Alimento alimento = new Alimento(0, nombre, cantidad, fechaCaducidad);
        alimento.setFormato(formato);
        
        if (alimentoServicio.getDao().crearAlimento(alimento)) {
            System.out.println("✅ Alimento creado con ID: " + alimento.getId());
        } else {
            System.out.println("❌ Error al crear alimento");
        }
    }

    private void listarAlimentos() {
        System.out.println("\n--- LISTA DE ALIMENTOS ---");
        List<Alimento> alimentos = alimentoServicio.getDao().leerTodos();
        
        if (alimentos.isEmpty()) {
            System.out.println("📭 No hay alimentos");
        } else {
            alimentos.forEach(System.out::println);
            System.out.println("Total: " + alimentos.size() + " alimentos");
        }
    }

    private void buscarAlimentoPorId() {
        System.out.println("\n--- BUSCAR POR ID ---");
        System.out.print("ID: ");
        
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Alimento alimento = alimentoServicio.getDao().leerPorId(id);
            
            if (alimento != null) {
                System.out.println("✅ Encontrado: " + alimento);
            } else {
                System.out.println("❌ No encontrado");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ ID debe ser número");
        }
    }

    private void actualizarAlimento() {
        System.out.println("\n--- ACTUALIZAR ALIMENTO ---");
        System.out.print("ID: ");
        
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Alimento existente = alimentoServicio.getDao().leerPorId(id);
            
            if (existente == null) {
                System.out.println("❌ Alimento no encontrado");
                return;
            }
            
            System.out.println("Actual: " + existente);
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Nuevo formato: ");
            String formato = scanner.nextLine();
            
            System.out.print("Nueva cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Nueva fecha (YYYY-MM-DD): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine());
            
            Alimento actualizado = new Alimento(id, nombre, cantidad, fecha);
            actualizado.setFormato(formato);
            
            if (alimentoServicio.getDao().actualizarAlimento(actualizado)) {
                System.out.println("✅ Actualizado correctamente");
            } else {
                System.out.println("❌ Error al actualizar");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error en los datos");
        }
    }

    private void eliminarAlimento() {
        System.out.println("\n--- ELIMINAR ALIMENTO ---");
        System.out.print("ID: ");
        
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Alimento alimento = alimentoServicio.getDao().leerPorId(id);
            
            if (alimento == null) {
                System.out.println("❌ Alimento no encontrado");
                return;
            }
            
            System.out.println("Eliminar: " + alimento);
            System.out.print("¿Confirmar? (s/n): ");
            String confirmar = scanner.nextLine();
            
            if (confirmar.equalsIgnoreCase("s")) {
                if (alimentoServicio.getDao().eliminar(id)) {
                    System.out.println("✅ Eliminado correctamente");
                } else {
                    System.out.println("❌ Error al eliminar");
                }
            } else {
                System.out.println("❌ Cancelado");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ ID debe ser número");
        }
    }

    private void serializarDatos() {
        System.out.println("\n--- SERIALIZAR ---");
        List<Alimento> alimentos = alimentoServicio.getDao().leerTodos();
        
        if (alimentos.isEmpty()) {
            System.out.println("📭 No hay datos");
            return;
        }
        
        if (alimentoServicio.getSerializador().serializarLista(alimentos)) {
            System.out.println("✅ Datos guardados en alimentos.dat");
        } else {
            System.out.println("❌ Error al guardar");
        }
    }

    private void deserializarDatos() {
        System.out.println("\n--- DESERIALIZAR ---");
        List<Alimento> alimentos = alimentoServicio.getSerializador().deserializarLista();
        
        if (alimentos.isEmpty()) {
            System.out.println("📭 No hay datos guardados");
            return;
        }
        
        System.out.println("Datos cargados:");
        alimentos.forEach(System.out::println);
        
        System.out.print("¿Cargar al sistema? (s/n): ");
        String cargar = scanner.nextLine();
        
        if (cargar.equalsIgnoreCase("s")) {
            // Limpiar actual
            List<Alimento> actuales = alimentoServicio.getDao().leerTodos();
            for (Alimento a : actuales) {
                alimentoServicio.getDao().eliminar(a.getId());
            }
            // Cargar nuevos
            for (Alimento a : alimentos) {
                alimentoServicio.getDao().crearAlimento(a);
            }
            System.out.println("✅ Datos cargados al sistema");
        }
    }

    private void confirmarSalida() {
        System.out.print("\n¿Salir? (s/n): ");
        String salir = scanner.nextLine();
        
        if (salir.equalsIgnoreCase("s")) {
            // Backup automático
            List<Alimento> alimentos = alimentoServicio.getDao().leerTodos();
            if (!alimentos.isEmpty()) {
                alimentoServicio.getSerializador().serializarLista(alimentos);
            }
            System.out.println("👋 ¡Hasta pronto!");
        } else {
            mostrarMenuPrincipal();
        }
    }

    private void cerrarSistema() {
        scanner.close();
    }
}