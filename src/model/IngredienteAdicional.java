package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IngredienteAdicional extends Entidade{
    private String nome;
    private double valor;

    private List<IngredienteEscolha> ingredienteEsolha;

    public IngredienteAdicional(Integer id) {
        setId(id);
    }

    public IngredienteAdicional() {
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

    @Override
    public String getInsert() {
        return "INSERT INTO ingrediente_adicional (nome, valor) VALUES (?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, nome);
        prepareStatement.setDouble(2, valor);

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId());  
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE ingrediente_adicional SET nome=?, valor=? WHERE id=?";
    
    }
}