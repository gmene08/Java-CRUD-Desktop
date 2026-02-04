package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Pedido extends Entidade {
    private String horaPedido;
    private int clienteId;
    private String numeroPedido;
    private int carrinhoId;
    private String dataPedido;
    private int statusPedidoId;
    private int entregaId;

    private List<Cliente> clientes;
    private Reembolso reembolso;
    private Carrinho carrinho;

    public Pedido(Integer id) {
        setId(id);
    }

    public Pedido() {
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(int carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getStatusPedidoId() {
        return statusPedidoId;
    }

    public void setStatusPedidoId(int statusPedidoId) {
        this.statusPedidoId = statusPedidoId;
    }

    public int getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(int entregaId) {
        this.entregaId = entregaId;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Reembolso getReembolso() {
        return reembolso;
    }

    public void setReembolso(Reembolso reembolso) {
        this.reembolso = reembolso;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO pedido (hora_pedido, cliente_id, numero_pedido, carrinho_id, data_pedido, status_pedido_id, entrega_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, horaPedido);
        prepareStatement.setInt(2, clienteId);
        prepareStatement.setString(3, numeroPedido);
        prepareStatement.setInt(4, carrinhoId);
        prepareStatement.setString(5, dataPedido);
        prepareStatement.setInt(6, statusPedidoId);
        prepareStatement.setInt(7, entregaId);

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(8, getId());  
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE pedido SET hora_pedido=?, cliente_id=?, numero_pedido=?, carrinho_id=?, data_pedido=?, status_pedido_id=?, entrega_id=? WHERE id=?";
    }
}
