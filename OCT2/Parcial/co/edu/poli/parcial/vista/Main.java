package co.edu.poli.parcial.vista;

import co.edu.poli.parcial.model.*;
import co.edu.poli.parcial.servicios.*;
import java.util.Scanner;

public class Main {
    private OperacionCRUD operatorCRUD;
    private Scanner scanner;
    private Proveedor[] proveedores;
    
    public static void main(String[] args) {
        Main main = new Main();
        main.inicializar();
        main.mostrarMenu();
    }
    
    public void inicializar() {
        operatorCRUD = new ImplementacionCRUD();
        scanner = new Scanner(System.in);
        
    
        proveedores = new Proveedor[]{
            new Proveedor(1, "China", "TecnoGlobal"),
            new Proveedor(2, "Italia", "ModaStyle"),
            new Proveedor(3, "Japón", "ElecCorp")
        };
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Buscar Producto");
            System.out.println("6. Serializar");
            System.out.println("7. Deserializar");
            System.out.println("8. Salir");
            System.out.print("Seleccione opción: ");
            
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
                    System.out.println("Opción inválida");
            }
        } while (opcion != 8);
    }
    
    public void menuCrearProducto() {
        System.out.println("\n--- Crear Producto ---");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
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
        
        if (proveedorIndex >= 0 && proveedorIndex < proveedores.length) {
            Producto producto = new Producto(codigo, nombre, precio, stock, proveedores[proveedorIndex]);
            
            System.out.print("Tipo (1-Electrónico, 2-Ropa): ");
            int tipo = scanner.nextInt();
            scanner.nextLine();
            
            if (tipo == 1) {
                System.out.print("Garantía (meses): ");
                int garantia = scanner.nextInt();
                Electronico electronico = new Electronico(codigo, nombre, precio, proveedores[proveedorIndex], garantia);
                producto.setElectronico(electronico);
            } else if (tipo == 2) {
                System.out.print("Talla: ");
                String talla = scanner.nextLine();
                Ropa ropa = new Ropa(codigo, nombre, precio, stock, proveedores[proveedorIndex], talla);
                producto.setRopa(ropa);
            }
            
            if (operatorCRUD.crearProducto(producto)) {
                System.out.println("Producto creado exitosamente");
            } else {
                System.out.println("Error al crear producto");
            }
        }
    }
    
    public void menuListarProductos() {
        System.out.println("\n--- Listar Productos ---");
        ImplementacionCRUD impl = (ImplementacionCRUD) operatorCRUD;
        System.out.println("Total productos: " + impl.getContador());
        
        if (impl.getContador() == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }
        
        for (int i = 0; i < impl.getContador(); i++) {
            Producto producto = impl.obtenerProductoPorIndice(i);
            
            if (producto != null) {
                String tipo = producto.getTipo();
                String detalle = "";
                
                if (producto.getElectronico() != null) {
                    detalle = "Garantía: " + producto.getElectronico().getGarantiaMeses() + " meses";
                } else if (producto.getRopa() != null) {
                    detalle = "Talla: " + producto.getRopa().getTalla();
                }
                
                System.out.println("Producto " + (i + 1) + ":");
                System.out.println("  Código: " + producto.getCodigo());
                System.out.println("  Nombre: " + producto.getNombre());
                System.out.println("  Precio: $" + producto.getPrecio());
                System.out.println("  Stock: " + producto.getStock());
                System.out.println("  Proveedor: " + producto.getProveedor().getNombre() + " (" + producto.getProveedor().getPaisOrigen() + ")");
                System.out.println("  Tipo: " + tipo);
                System.out.println("  Detalle: " + detalle);
                System.out.println("  --------------------");
            }
        }
    }    
    public void menuActualizarProducto() {
        System.out.println("\n--- Actualizar Producto ---");
        System.out.print("Código del producto a actualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Producto productoExistente = operatorCRUD.leerProducto(codigo);
        if (productoExistente != null) {
            System.out.println("Producto encontrado: " + productoExistente);
            
        
            System.out.print("Nuevo nombre (" + productoExistente.getNombre() + "): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                productoExistente.setNombre(nuevoNombre);
            }
            
            System.out.print("Nuevo precio (" + productoExistente.getPrecio() + "): ");
            String precioStr = scanner.nextLine();
            if (!precioStr.isEmpty()) {
                productoExistente.setPrecio(Double.parseDouble(precioStr));
            }
            
            if (operatorCRUD.actualizarProducto(productoExistente)) {
                System.out.println("Producto actualizado exitosamente");
            } else {
                System.out.println("Error al actualizar producto");
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }
    
    public void menuEliminarProducto() {
        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Código del producto a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        if (operatorCRUD.eliminarProducto(codigo)) {
            System.out.println("Producto eliminado");
        } else {
            System.out.println("Producto no encontrado");
        }
    }
    
    public void menuBuscarProducto() {
        System.out.println("\n--- Buscar Producto ---");
        System.out.print("Código del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        
        Producto producto = operatorCRUD.leerProducto(codigo);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
            System.out.println("Tipo: " + producto.getTipo());
            if (producto.getElectronico() != null) {
                System.out.println("Garantía: " + producto.getElectronico().getGarantiaMeses() + " meses");
            }
            if (producto.getRopa() != null) {
                System.out.println("Talla: " + producto.getRopa().getTalla());
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }
    
    public void menuSerializar() {
        System.out.println("\n--- Serializar ---");
        System.out.print("Nombre del archivo (productos.dat): ");
        String archivo = scanner.nextLine();
        if (archivo.isEmpty()) {
            archivo = "productos.dat";
        }
        
        if (operatorCRUD.serializarProducto(archivo)) {
            System.out.println("Datos serializados exitosamente en " + archivo);
        } else {
            System.out.println("Error al serializar datos");
        }
    }
    
    public void menuDeserializar() {
        System.out.println("\n--- Deserializar ---");
        System.out.print("Nombre del archivo a cargar (productos.dat): ");
        String archivo = scanner.nextLine();
        if (archivo.isEmpty()) {
            archivo = "productos.dat";
        }
       
        if (!operatorCRUD.establecintvq(archivo)) {
            System.out.println("El archivo " + archivo + " no existe");
            return;
        }
        
        Producto producto = operatorCRUD.deserializarProducto(archivo);
        if (producto != null) {
            System.out.println("Datos deserializados exitosamente");
            System.out.println("Primer producto cargado: " + producto);
        } else {
            System.out.println("Error al deserializar datos");
        }
    }
}