package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cupom extends Entidade {
    private double valorCupom;
    private String codigo;
    private String validade;
    
    private Pagamento pagamento;

    public Cupom() {
    }

    public Cupom(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorCupom() {
        return valorCupom;
    }

    public void setValorCupom(double valorCupom) {
        this.valorCupom = valorCupom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO cupom (valor, codigo, validade, pagamento_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setDouble(1, valorCupom); 
        preparedStatement.setString(2, codigo);    
        preparedStatement.setString(3, validade);  

        if (pagamento != null) {
            preparedStatement.setInt(4, pagamento.getId()); 
        }

        if (getId() != 0) {
            preparedStatement.setInt(5, getId());
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE cupom SET valor = ?, codigo = ?, validade = ?, pagamento_id = ? WHERE id = ?";
    }

}
