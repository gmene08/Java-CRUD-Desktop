package model;

import java.util.List;

public class IngredienteAdicional {
    private int id;
    private String nome;
    private double valor;

    private List<IngredienteEscolha> ingredienteEsolha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<IngredienteEscolha> getIngredienteEsolha() {
        return ingredienteEsolha;
    }

    public void setIngredienteEsolha(List<IngredienteEscolha> ingredienteEsolha) {
        this.ingredienteEsolha = ingredienteEsolha;
    }
    
    
}