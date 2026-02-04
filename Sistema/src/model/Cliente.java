package model;

public class Cliente {
    private int id;
    private String nome;
    private Telefone telefone;

    public Cliente() {
    }

    public Cliente(int id, String nome, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
    
}