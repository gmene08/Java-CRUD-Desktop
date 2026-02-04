package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Entrega extends Entidade{
    private String tipoEntrega;
    private int statusPedidoId;
    
    private List<Cliente> clientes;
    private Pedido pedido;
    private Delivery delivery;

    public Entrega(Integer id) {
        setId(id);
    }

    public Entrega() {
    }
    
    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public int getStatusPedidoId() {
        return statusPedidoId;
    }

    public void setStatusPedidoId(int statusPedidoId) {
        this.statusPedidoId = statusPedidoId;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO entrega (tipo_entrega, status_pedido_id, pedido_id, delivery_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, tipoEntrega);
        prepareStatement.setInt(2, statusPedidoId);

        if (pedido != null) {
            prepareStatement.setInt(3, pedido.getId());  
        } else {
            prepareStatement.setNull(3, java.sql.Types.INTEGER); 
        }

        if (delivery != null) {
            prepareStatement.setInt(4, delivery.getId());  
        } else {
            prepareStatement.setNull(4, java.sql.Types.INTEGER);
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(5, getId()); 
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE entrega SET tipo_entrega=?, status_pedido_id=?, pedido_id=?, delivery_id=? WHERE id=?";
    }
}
