package model;

import java.util.List;

public class IngredienteRemover {
    private int id;
    private String nome;

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

    public List<IngredienteEscolha> getIngredienteEsolha() {
        return ingredienteEsolha;
    }

    public void setIngredienteEsolha(List<IngredienteEscolha> ingredienteEsolha) {
        this.ingredienteEsolha = ingredienteEsolha;
    }

    
    
}