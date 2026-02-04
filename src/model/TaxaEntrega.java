package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaxaEntrega extends Entidade{
    private int enderecoId;
    private double taxaEntrega;
    
    private Endereco endereco;

    public TaxaEntrega(Integer id) {
        setId(id);
    }

    public TaxaEntrega() {
    }

    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO taxa_entrega (endereco_id, taxa_entrega) VALUES (?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, enderecoId);  
        prepareStatement.setDouble(2, taxaEntrega);  

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId()); 
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE taxa_entrega SET endereco_id=?, taxa_entrega=? WHERE id=?";
    }
}
