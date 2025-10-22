package com.cosmotravel.service;

import com.cosmotravel.crud.OperacionCRUD;
import com.cosmotravel.crud.ImplementacionOperacionCRUD;

public class AlimentoServicio {
    private Serializador serializador;
    private OperacionCRUD dao;

    public AlimentoServicio() {
        this.serializador = new Serializador();
        this.dao = new ImplementacionOperacionCRUD();
    }

    public Serializador getSerializador() {
        return serializador;
    }

    public OperacionCRUD getDao() {
        return dao;
    }
}