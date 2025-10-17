package co.edu.poli.parcial.vista;

import co.edu.poli.parcial.servicios.*;
import co.edu.poli.parcial.model.*;

import java.util.Scanner;

public class Main {
    private OperacionCRUD operacionCRUD;
    private Scanner scanner;
    private Proveedor[] proveedores;
    
    public static void main(String[] args) {
        Main main = new Main();
        main.inicializar();
        main.mostrarMenu();
    }
    
    public void inicializar() {
        operacionCRUD = new ImplementacionCRUD();
        scanner = new Scanner(System.in);
        
        proveedores = new Proveedor[]{
            new Proveedor(1, "China", "TecnoGlobal"),
            new Proveedor(2, "Italia", "ModaStyle"),
            new Proveedor(3, "Japón", "TechWorld"),
            new Proveedor(4, "Colombia", "NataStyle")
        };
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Crear Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Buscar Producto");
            System.out.println("6. Serializar");
            System.out.println("7. Deserializar");
            System.out.println("8. Salir");
            System.out.print("Seleccione opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    menuCrearProducto();
                    break;
                case 2:
                    menuListarProductos();
                    break;
                case 3:
                    menuActualizarProducto();
                    break;
                case 4:
                    menuEliminarProducto();
                    break;
                case 5:
                    menuBuscarProducto();
                    break;
                case 6:
                    menuSerializar();
                    break;
                case 7:
                    menuDeserializar();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 8);
    }
    
    public void menuCrearProducto() {
        System.out.println("\n--- CREAR PRODUCTO ---");
        
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        if (((ImplementacionCRUD) operacionCRUD).existeProducto(codigo)) {
            System.out.println("Ya existe producto con ese codigo");
            return;
        }
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Proveedores disponibles:");
        for (int i = 0; i < proveedores.length; i++) {
            System.out.println((i + 1) + ". " + proveedores[i]);
        }
        System.out.print("Seleccione proveedor (1-" + proveedores.length + "): ");
        int proveedorIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (proveedorIndex < 0 || proveedorIndex >= proveedores.length) {
            System.out.println("Proveedor invalido");
            return;
        }
        
        Proveedor proveedorSeleccionado = proveedores[proveedorIndex];
        Producto nuevoProducto = new Producto(codigo, nombre, precio, stock, proveedorSeleccionado);
        
        System.out.println("Tipo de producto:");
        System.out.println("1. Electronico");
        System.out.println("2. Ropa");
        System.out.print("Seleccione tipo (1-2): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        if (tipo == 1) {
            System.out.print("Garantia (meses): ");
            int garantia = scanner.nextInt();
            scanner.nextLine();
            Electronico electronico = new Electronico(codigo, nombre, precio, proveedorSeleccionado, garantia);
            nuevoProducto.setElectronico(electronico);
        } else if (tipo == 2) {
            System.out.print("Talla (S/M/L/XL): ");
            String talla = scanner.nextLine();
            Ropa ropa = new Ropa(codigo, nombre, precio, stock, proveedorSeleccionado, talla);
            nuevoProducto.setRopa(ropa);
        } else {
            System.out.println("Tipo invalido");
            return;
        }
        
        if (operacionCRUD.crearProducto(nuevoProducto)) {
            System.out.println("Producto creado exitosamente");
        }
    }
    
    public void menuListarProductos() {
        System.out.println("\n--- LISTAR PRODUCTOS ---");
        ImplementacionCRUD impl = (ImplementacionCRUD) operacionCRUD;
        System.out.println("Total productos: " + impl.getContador());
        
        if (impl.getContador() == 0) {
            System.out.println("No hay productos registrados");
            return;
        }
        
        for (int i = 0; i < impl.getContador(); i++) {
            Producto producto = impl.obtenerProductoPorIndice(i);
            System.out.println("\nProducto " + (i + 1) + ":");
            System.out.println("  Codigo: " + producto.getCodigo());
            System.out.println("  Nombre: " + producto.getNombre());
            System.out.println("  Precio: $" + producto.getPrecio());
            System.out.println("  Stock: " + producto.getStock());
            System.out.println("  Proveedor: " + producto.getProveedor().getNombre());
            System.out.println("  Tipo: " + producto.getTipo());
            
            if (producto.getElectronico() != null) {
                System.out.println("  Garantia: " + producto.getElectronico().getGarantiaMeses() + " meses");
            }
            if (producto.getRopa() != null) {
                System.out.println("  Talla: " + producto.getRopa().getTalla());
            }
            System.out.println("  --------------------");
        }
    }
    
    public void menuActualizarProducto() {
        System.out.println("\n--- ACTUALIZAR PRODUCTO ---");
        System.out.print("Codigo del producto a actualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Producto productoExistente = operacionCRUD.leerProducto(codigo);
        if (productoExistente == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.println("Producto actual: " + productoExistente);
        
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        productoExistente.setNombre(nombre);
        
        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();
        productoExistente.setPrecio(precio);
        
        System.out.print("Nuevo stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        productoExistente.setStock(stock);
        
        if (operacionCRUD.actualizarProducto(productoExistente)) {
            System.out.println("Producto actualizado exitosamente");
        }
    }
    
    public void menuEliminarProducto() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");
        System.out.print("Codigo del producto a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Producto producto = operacionCRUD.leerProducto(codigo);
        if (producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.println("Producto a eliminar: " + producto);
        System.out.print("Confirmar eliminacion (S/N): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("S")) {
            if (operacionCRUD.eliminarProducto(codigo)) {
                System.out.println("Producto eliminado");
            }
        } else {
            System.out.println("Eliminacion cancelada");
        }
    }
    
    public void menuBuscarProducto() {
        System.out.println("\n--- BUSCAR PRODUCTO ---");
        System.out.print("Codigo del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Producto producto = operacionCRUD.leerProducto(codigo);
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(producto);
            System.out.println("Tipo: " + producto.getTipo());
            if (producto.getElectronico() != null) {
                System.out.println("Garantia: " + producto.getElectronico().getGarantiaMeses() + " meses");
            }
            if (producto.getRopa() != null) {
                System.out.println("Talla: " + producto.getRopa().getTalla());
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }
    
    public void menuSerializar() {
        System.out.println("\n--- SERIALIZAR ---");
        System.out.print("Nombre del archivo (productos.dat): ");
        String archivo = scanner.nextLine();
        if (archivo.isEmpty()) {
            archivo = "productos.dat";
        }
        
        if (operacionCRUD.serializarProducto(archivo)) {
            System.out.println("Datos serializados exitosamente");
        } else {
            System.out.println("Error al serializar");
        }
    }
    
    public void menuDeserializar() {
        System.out.println("\n--- DESERIALIZAR ---");
        System.out.print("Nombre del archivo (productos.dat): ");
        String archivo = scanner.nextLine();
        if (archivo.isEmpty()) {
            archivo = "productos.dat";
        }
        
        if (!operacionCRUD.establecintvq(archivo)) {
            System.out.println("El archivo no existe");
            return;
        }
        
        Producto producto = operacionCRUD.deserializarProducto(archivo);
        if (producto != null) {
            System.out.println("Datos deserializados exitosamente");
            System.out.println("Primer producto cargado: " + producto.getNombre());
        } else {
            System.out.println("Error al deserializar");
        }
    }
}