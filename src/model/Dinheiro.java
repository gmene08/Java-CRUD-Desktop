package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dinheiro extends Entidade {

    private double valorEntregue;
    private MetPagamento metPagamento;

    public Dinheiro(Integer id) {
        setId(id);
    }
    
    public Dinheiro() {
    }

    public double getValorEntregue() {
        return valorEntregue;
    }

    public void setValorEntregue(double valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    public MetPagamento getMetPagamento() {
        return metPagamento;
    }

    public void setMetPagamento(MetPagamento metPagamento) {
        this.metPagamento = metPagamento;
    }
    
    @Override
    public String getInsert() {
        return "INSERT INTO dinheiro (valor_entregue, met_pagamento_id) VALUES (?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setDouble(1, valorEntregue); 
        if (metPagamento != null) {
            prepareStatement.setInt(2, metPagamento.getId()); 
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId()); 
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE dinheiro SET valor_entregue=?, met_pagamento_id=? WHERE id=?";
    }
    
}
