package com.es.david.vacinas.modelo;

import java.io.Serializable;

public class Vacina implements Serializable {
    private String nome;
    private String data;
    private String detalhes;

    public Vacina() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
