package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetPagamento extends Entidade{
    private Integer dinheiroId;
    private Integer cartaoId;

    private Pagamento pagamento;
    private Cartao cartao;
    private Dinheiro dinheiro;

    public MetPagamento(Integer id) {
        setId(id);
    }

    public MetPagamento() {
    }
    
    public Integer getDinheiroId() {
        return dinheiroId;
    }

    public void setDinheiroId(Integer dinheiroId) {
        this.dinheiroId = dinheiroId;
    }

    public Integer getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Integer cartaoId) {
        this.cartaoId = cartaoId;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }

    @Override
    public String getInsert() {
       return "INSERT INTO met_pagamento (dinheiro_id, cartao_id, pagamento_id) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        if (dinheiro != null) {
            prepareStatement.setInt(1, dinheiro.getId());  
        } else {
            prepareStatement.setNull(1, java.sql.Types.INTEGER);  
        }

        if (cartao != null) {
            prepareStatement.setInt(2, cartao.getId());  
        } else {
            prepareStatement.setNull(2, java.sql.Types.INTEGER);  
        }

        if (pagamento != null) {
            prepareStatement.setInt(3, pagamento.getId());  
        } else {
            prepareStatement.setNull(3, java.sql.Types.INTEGER); 
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(4, getId());  
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE met_pagamento SET dinheiro_id=?, cartao_id=?, pagamento_id=? WHERE id=?";
    
    }
            
}