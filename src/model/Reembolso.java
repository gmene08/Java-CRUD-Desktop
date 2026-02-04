package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reembolso extends Entidade{
    private int pedidoId;
    private String motivo;

    private Pedido pedido;

    public Reembolso(Integer id) {
        setId(id);
    }

    public Reembolso() {
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO reembolso (pedido_id, motivo) VALUES (?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, pedidoId); 
        prepareStatement.setString(2, motivo); 

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId()); 
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE reembolso SET pedido_id=?, motivo=? WHERE id=?";
    }
}