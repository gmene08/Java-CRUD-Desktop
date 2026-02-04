package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Carrinho extends Entidade{
    private int quantidade;
    private int ingredienteEscolhaId;
    
    private List<Pedido> pedido;
    private List<IngredienteEscolha> ingredienteEscolha;
    private List<Produto>produto;

    public Carrinho(Integer id) {
        setId(id);
    }

    public Carrinho() {
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIngredienteEscolhaId() {
        return ingredienteEscolhaId;
    }

    public void setIngredienteEscolhaId(int ingredienteEscolhaId) {
        this.ingredienteEscolhaId = ingredienteEscolhaId;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<IngredienteEscolha> getIngredienteEscolha() {
        return ingredienteEscolha;
    }

    public void setIngredienteEscolha(List<IngredienteEscolha> ingredienteEscolha) {
        this.ingredienteEscolha = ingredienteEscolha;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public String getInsert() {
        return "Barro(quantidade) values(?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, quantidade);
            if(getId()!=null&& getId() > 0)
                prepareStatement.setInt(2, getId());
    }

    @Override
    public String getupdate() {
        return "Carrinho set quantidade=?";
    }
    
    
}
