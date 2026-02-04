package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delivery extends Entidade {
    private int chaveEntrega;
    private String numero;
    private String complemento;
    
    private Entrega entrega;

    public Delivery(Integer id) {
        setId(id);
    }

    public Delivery() {
    }

    public int getChaveEntrega() {
        return chaveEntrega;
    }

    public void setChaveEntrega(int chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO delivery (chave_entrega, numero, complemento, entrega_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, chaveEntrega);
        prepareStatement.setString(2, numero);
        prepareStatement.setString(3, complemento);
        if (entrega != null) {
            prepareStatement.setInt(4, entrega.getId());
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(5, getId());
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE delivery SET chave_entrega=?, numero=?, complemento=?, entrega_id=? WHERE id=?";
    }
}
