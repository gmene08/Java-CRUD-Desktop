package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cartao extends Entidade{
    private String numCartao;
    private String cvv;
    private Integer tipo; // 1: crédito, 2: débito

    private MetPagamento metPagamento;

    public Cartao(Integer id) {
        setId(id);
    }
    
    public Cartao() {
    }
    
    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public MetPagamento getMetPagamento() {
        return metPagamento;
    }

    public void setMetPagamento(MetPagamento metPagamento) {
        this.metPagamento = metPagamento;
    }

    @Override
    public String getInsert() {
        return "cartao (numCartao,cvv, tipo) values(?,?,?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, numCartao);
        prepareStatement.setString(2, cvv);
            if(getId()!=null && getId() > 0)
                prepareStatement.setInt(2, getId());
    }

    @Override
    public String getupdate() {
        return "cartao set numCartao = ?, cvv = ?, tipo = ? where id = ?";
    }
}
