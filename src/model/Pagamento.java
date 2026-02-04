package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pagamento extends Entidade{
    private int metPagamentoId;
    private int cupomId;
    private int pedidoId;

    private Pedido pedido;
    private Cupom cupom;

    public Pagamento(Integer id) {
        setId(id);
    }

    public Pagamento() {
    }
    
    public int getMetPagamentoId() {
        return metPagamentoId;
    }

    public void setMetPagamentoId(int metPagamentoId) {
        this.metPagamentoId = metPagamentoId;
    }

    public int getCupomId() {
        return cupomId;
    }

    public void setCupomId(int cupomId) {
        this.cupomId = cupomId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO pagamento (met_pagamento_id, cupom_id, pedido_id) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, metPagamentoId);

        if (cupom != null) {
            prepareStatement.setInt(2, cupom.getId()); 
        } else {
            prepareStatement.setNull(2, java.sql.Types.INTEGER);  
        }

        if (pedido != null) {
            prepareStatement.setInt(3, pedido.getId());  
        } else {
            prepareStatement.setNull(3, java.sql.Types.INTEGER);  
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(4, getId());  
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE pagamento SET met_pagamento_id=?, cupom_id=?, pedido_id=? WHERE id=?";
    }
}
