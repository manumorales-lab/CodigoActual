package com.cosmotravel.service;

import com.cosmotravel.modelo.Alimento;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Serializador {
    private String archivoDatos = "alimentos.dat";

    public Serializador() {}

    public boolean serializarLista(List<Alimento> alimentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos))) {
            oos.writeObject(alimentos);
            return true;
        } catch (IOException e) {
            System.err.println("Error serializando: " + e.getMessage());
            return false;
        }
    }

    public List<Alimento> deserializarLista() {
        File archivo = new File(archivoDatos);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDatos))) {
            @SuppressWarnings("unchecked")
            List<Alimento> alimentos = (List<Alimento>) ois.readObject();
            return alimentos;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializando: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}