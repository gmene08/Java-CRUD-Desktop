package model;

import java.util.List;

public class Carrinho {
    private int id;
    private int quantidade;
    private int ingredienteEscolhaId;
    
    private List<Pedido> pedido;
    private List<IngredienteEscolha> ingredienteEscolha;
    private List<Produto>produto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
