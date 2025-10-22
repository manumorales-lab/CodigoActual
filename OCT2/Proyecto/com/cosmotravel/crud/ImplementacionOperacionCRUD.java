package com.cosmotravel.crud;

import com.cosmotravel.modelo.Alimento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImplementacionOperacionCRUD implements OperacionCRUD {
    private List<Alimento> inventario;
    private int siguienteId;

    public ImplementacionOperacionCRUD() {
        this.inventario = new ArrayList<>();
        this.siguienteId = 1;
    }

    @Override
    public boolean crearAlimento(Alimento alimento) {
        try {
            alimento.setId(siguienteId++);
            return inventario.add(alimento);
        } catch (Exception e) {
            System.out.println("Error al crear alimento: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Alimento> leerTodos() {
        return new ArrayList<>(inventario);
    }

    @Override
    public Alimento leerPorId(int id) {
        try {
            return inventario.stream()
                    .filter(a -> a.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizarAlimento(Alimento alimento) {
        try {
            for (int i = 0; i < inventario.size(); i++) {
                if (inventario.get(i).getId() == alimento.getId()) {
                    inventario.set(i, alimento);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error al actualizar alimento: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        try {
            return inventario.removeIf(a -> a.getId() == id);
        } catch (Exception e) {
            System.out.println("Error al eliminar alimento: " + e.getMessage());
            return false;
        }
    }

    // Método adicional para buscar por nombre
    public List<Alimento> buscarPorNombre(String nombre) {
        try {
            return inventario.stream()
                    .filter(a -> a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error al buscar por nombre: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Método adicional para obtener total
    public int obtenerTotalAlimentos() {
        return inventario.size();
    }

    // Método para verificar si el inventario está vacío
    public boolean estaVacio() {
        return inventario.isEmpty();
    }

    // Método para limpiar todo el inventario
    public void limpiarInventario() {
        inventario.clear();
        siguienteId = 1;
    }
}