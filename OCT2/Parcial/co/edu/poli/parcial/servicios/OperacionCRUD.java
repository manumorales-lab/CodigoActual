package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.*;

public interface OperacionCRUD {
    boolean crearProducto(Producto producto);
    Producto leerProducto(int codigo);
    Producto leerTodos(Producto producto);
    boolean actualizarProducto(Producto producto);
    boolean eliminarProducto(int codigo);
    boolean serializarProducto(String archive);
    Producto deserializarProducto(String archive);
    boolean establecintvq(String archive);
}