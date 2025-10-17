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
        if (contador < capacidad) {
            productos[contador] = producto;
            contador++;
            return true;
        }
        return false;
    }
    
    @Override
    public Producto leerProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo() == codigo) {
                return productos[i];
            }
        }
        return null;
    }
    
    @Override
    public Producto leerTodos(Producto producto) {
        // Nota: Este método parece incorrecto en el diagrama, se implementa básico
        if (contador > 0) {
            return productos[0]; // Retorna el primero como ejemplo
        }
        return null;
    }
    
    @Override
    public boolean actualizarProducto(Producto producto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo() == producto.getCodigo()) {
                productos[i] = producto;
                return true;
            }
        }
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
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean serializarProducto(String archive) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archive))) {
            oos.writeObject(productos);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    @Override
    public Producto deserializarProducto(String archive) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archive))) {
            Producto[] productosCargados = (Producto[]) ois.readObject();
            if (productosCargados != null && productosCargados.length > 0) {
                return productosCargados[0]; // Retorna el primero
            }
        } catch (IOException | ClassNotFoundException e) {
            // Manejo de error
        }
        return null;
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

	public Producto obtenerProductoPorIndice(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
