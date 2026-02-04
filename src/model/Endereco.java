package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Endereco extends Entidade{
    private String rua;
    private String cep;
    private double distancia;

    private Delivery delivery;
    private Bairro bairro;

    public Endereco(Integer id) {
        setId(id);
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getInsert() {
         return "INSERT INTO endereco (rua, cep, distancia, delivery_id, bairro_id) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, rua);
        prepareStatement.setString(2, cep);
        prepareStatement.setDouble(3, distancia);

        if (delivery != null) {
            prepareStatement.setInt(4, delivery.getId()); 
        } else {
            prepareStatement.setNull(4, java.sql.Types.INTEGER); 
        }

        if (bairro != null) {
            prepareStatement.setInt(5, bairro.getId()); 
        } else {
            prepareStatement.setNull(5, java.sql.Types.INTEGER); 
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(6, getId()); 
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE endereco SET rua=?, cep=?, distancia=?, delivery_id=?, bairro_id=? WHERE id=?";
    }
    
}
