package model;

import java.util.List;

public class Entrega {
    private int id;
    private String tipoEntrega;
    private int statusPedidoId;
    
    private List<Cliente> clientes;
    private Pedido pedido;
    private Delivery delivery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
}
