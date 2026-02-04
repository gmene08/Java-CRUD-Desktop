package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IngredienteRemover extends Entidade{
    private String nome;

    private List<IngredienteEscolha> ingredienteEsolha;

    public IngredienteRemover(Integer id) {
        setId(id);
    }

   public IngredienteRemover() {
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

    @Override
    public String getInsert() {
        return "INSERT INTO ingrediente_remover (nome) VALUES (?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, nome);

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(2, getId());
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE ingrediente_remover SET nome=? WHERE id=?";
    }

}