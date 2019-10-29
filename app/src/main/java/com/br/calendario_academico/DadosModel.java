package com.br.calendario_academico;

public class DadosModel {
    int idLegenda;
    String Descricao;
    String DataInicio;
    String DataFim;
    String Cor;
    int Feriado;

    public int getIdLegenda() {
        return idLegenda;
    }

    public void setIdLegenda(int idLegenda) {
        this.idLegenda = idLegenda;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(String dataInicio) {
        DataInicio = dataInicio;
    }

    public String getDataFim() {
        return DataFim;
    }

    public void setDataFim(String dataFim) {
        DataFim = dataFim;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    public int isFeriado() {
        return Feriado;
    }

    public void setFeriado(int feriado) {
        Feriado = feriado;
    }

    public DadosModel(int idLegenda, String descricao, String dataInicio, String dataFim, String cor, int feriado) {
        this.idLegenda = idLegenda;
        Descricao = descricao;
        DataInicio = dataInicio;
        DataFim = dataFim;
        Cor = cor;
        Feriado = feriado;
    }
}
