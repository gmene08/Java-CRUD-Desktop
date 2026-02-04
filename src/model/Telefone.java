package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Telefone extends Entidade {
    private int dd;
    private String numero;

    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;

    public Telefone(Integer id) {
        setId(id);
    }
    
    public Telefone() {
    }
    
    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO telefone (dd, numero) VALUES (?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, dd);
        prepareStatement.setString(2, numero);
        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId());
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE telefone SET dd = ?, numero = ? WHERE id = ?";
    }

}
