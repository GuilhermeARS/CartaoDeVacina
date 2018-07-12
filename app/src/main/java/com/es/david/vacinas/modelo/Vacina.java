package com.es.david.vacinas.modelo;

public class Vacina {
    private String nomeVacina;
    private String dataVacina;
    private String detalhesVacina;

    public Vacina() {

    }

    public Vacina(String nomeVacina, String dataVacina, String detalhesVacina) {
        this.nomeVacina = nomeVacina;
        this.dataVacina = dataVacina;
        this.detalhesVacina = detalhesVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(String dataVacina) {
        this.dataVacina = dataVacina;
    }

    public String getDetalhesVacina() {
        return detalhesVacina;
    }

    public void setDetalhesVacina(String detalhesVacina) {
        this.detalhesVacina = detalhesVacina;
    }
}
