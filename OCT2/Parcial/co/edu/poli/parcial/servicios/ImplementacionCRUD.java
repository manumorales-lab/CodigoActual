package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.*;
import java.io.*;

public class ImplementacionCRUD implements OperacionCRUD {
    private Producto[] productos;
    private int contador;
    private int capacidad = 100;
    
    public ImplementacionCRUD() {
        productos = new Producto[capacidad];
        contador = 0;
    }
    
    @Override
    public boolean crearProducto(Producto producto) {
        if (contador >= capacidad) {
            System.out.println("Error: Capacidad máxima alcanzada");
            return false;
        }
        
        if (leerProducto(producto.getCodigo()) != null) {
            System.out.println("Error: Ya existe producto con código " + producto.getCodigo());
            return false;
        }
        
        productos[contador] = producto;
        contador++;
        System.out.println("Producto creado exitosamente");
        return true;
    }
    
    @Override
    public Producto leerProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                return productos[i];
            }
        }
        return null;
    }
    
    @Override
    public Producto leerTodos(Producto producto) {
        if (contador > 0) {
            return productos[0];
        }
        return null;
    }
    
    @Override
    public boolean actualizarProducto(Producto producto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo() == producto.getCodigo()) {
                productos[i] = producto;
                System.out.println("Producto actualizado exitosamente");
                return true;
            }
        }
        System.out.println("Error: Producto no encontrado");
        return false;
    }
    
    @Override
    public boolean eliminarProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo() == codigo) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[contador - 1] = null;
                contador--;
                System.out.println("Producto eliminado exitosamente");
                return true;
            }
        }
        System.out.println("Error: Producto no encontrado");
        return false;
    }
    
    @Override
    public boolean serializarProducto(String archive) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archive))) {
            oos.writeInt(contador);
            for (int i = 0; i < contador; i++) {
                oos.writeObject(productos[i]);
            }
            System.out.println("Productos serializados en: " + archive);
            return true;
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Producto deserializarProducto(String archive) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archive))) {
            int cantidad = ois.readInt();
            Producto[] productosCargados = new Producto[cantidad];
            
            for (int i = 0; i < cantidad; i++) {
                productosCargados[i] = (Producto) ois.readObject();
            }
            
            this.productos = new Producto[capacidad];
            this.contador = 0;
            
            for (Producto p : productosCargados) {
                if (contador < capacidad && p != null) {
                    productos[contador] = p;
                    contador++;
                }
            }
            
            System.out.println("Productos cargados desde: " + archive);
            return (contador > 0) ? productos[0] : null;
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean establecintvq(String archive) {
        File file = new File(archive);
        return file.exists();
    }
    
    public int getContador() {
        return contador;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public boolean existeProducto(int codigo) {
        return leerProducto(codigo) != null;
    }
    
    public Producto obtenerProductoPorIndice(int indice) {
        if (indice >= 0 && indice < contador) {
            return productos[indice];
        }
        return null;
    }
    
    public void mostrarEstadisticas() {
        int electronicos = 0;
        int ropa = 0;
        
        for (int i = 0; i < contador; i++) {
            if (productos[i].getElectronico() != null) {
                electronicos++;
            } else if (productos[i].getRopa() != null) {
                ropa++;
            }
        }
        
        System.out.println("=== ESTADISTICAS ===");
        System.out.println("Electrónicos: " + electronicos);
        System.out.println("Ropa: " + ropa);
        System.out.println("Total: " + contador);
        System.out.println("Capacidad: " + capacidad);
    }
}