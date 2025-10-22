package com.cosmotravel.crud;

import com.cosmotravel.modelo.Alimento;
import java.util.List;

public interface OperacionCRUD {
    boolean crearAlimento(Alimento alimento);
    List<Alimento> leerTodos();
    Alimento leerPorId(int id);
    boolean actualizarAlimento(Alimento alimento);
    boolean eliminar(int id);
}