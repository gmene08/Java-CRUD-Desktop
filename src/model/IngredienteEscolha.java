package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredienteEscolha extends Entidade {

    private Integer ingredienteEscolhaId;
    private Integer ingredienteRemoverId;

    private Carrinho carrinho;
    private IngredienteRemover ingredienteRemover;
    private IngredienteAdicional ingredienteAdicional;

    public IngredienteEscolha(Integer iid) {
        setId(iid);
    }

    public IngredienteEscolha() {
    }

    public Integer getIngredienteEscolhaId() {
        return ingredienteEscolhaId;
    }

    public void setIngredienteEscolhaId(Integer ingredienteEscolhaId) {
        this.ingredienteEscolhaId = ingredienteEscolhaId;
    }

    public Integer getIngredienteRemoverId() {
        return ingredienteRemoverId;
    }

    public void setIngredienteRemoverId(Integer ingredienteRemoverId) {
        this.ingredienteRemoverId = ingredienteRemoverId;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public IngredienteRemover getIngredienteRemover() {
        return ingredienteRemover;
    }

    public void setIngredienteRemover(IngredienteRemover ingredienteRemover) {
        this.ingredienteRemover = ingredienteRemover;
    }

    public IngredienteAdicional getIngredienteAdicional() {
        return ingredienteAdicional;
    }

    public void setIngredienteAdicional(IngredienteAdicional ingredienteAdicional) {
        this.ingredienteAdicional = ingredienteAdicional;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO ingrediente_escolha (ingrediente_remover_id, ingrediente_adicional_id, carrinho_id) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, ingredienteRemoverId);
        prepareStatement.setInt(2, ingredienteAdicional != null ? ingredienteAdicional.getId() : 0);
        prepareStatement.setInt(3, carrinho != null ? carrinho.getId() : 0);

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(4, getId());
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE ingrediente_escolha SET ingrediente_remover_id=?, ingrediente_adicional_id=?, carrinho_id=? WHERE id=?";
    }
}
