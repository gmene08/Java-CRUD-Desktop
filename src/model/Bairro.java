package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bairro extends Entidade{
    private String nome;
    private Endereco endereco;

    public Bairro(Integer id) {
        setId(id);
    }

    public Bairro() {
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getInsert() {
        return "Barro(nome) values(?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, nome);
            if(getId()!=null&& getId() > 0)
                prepareStatement.setInt(2, getId());
    }

    @Override
    public String getupdate() {
        return "Bairro set nome=?";
    }
    
}
