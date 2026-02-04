package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Pedido;

public class PedidoDTO extends InterfaceDTO {
    public String id;
    public String horaPedido;
    public String clienteId;
    public String numeroPedido;
    public String carrinhoId;
    public String dataPedido;
    public String statusPedidoId;
    public String entregaId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Pedido pedido = (Pedido) e;
        id = String.valueOf(pedido.getId());
        horaPedido = pedido.getHoraPedido();
        clienteId = String.valueOf(pedido.getClienteId());
        numeroPedido = pedido.getNumeroPedido();
        carrinhoId = String.valueOf(pedido.getCarrinhoId());
        dataPedido = pedido.getDataPedido();
        statusPedidoId = String.valueOf(pedido.getStatusPedidoId());
        entregaId = String.valueOf(pedido.getEntregaId());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Pedido pedido = new Pedido();
        pedido.setId(Integer.parseInt(id));
        pedido.setHoraPedido(horaPedido);
        pedido.setClienteId(Integer.parseInt(clienteId));
        pedido.setNumeroPedido(numeroPedido);
        pedido.setCarrinhoId(Integer.parseInt(carrinhoId));
        pedido.setDataPedido(dataPedido);
        pedido.setStatusPedidoId(Integer.parseInt(statusPedidoId));
        pedido.setEntregaId(Integer.parseInt(entregaId));
        return pedido;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Hora Pedido", "Cliente ID", "Número Pedido", "Carrinho ID", "Data Pedido", "Status Pedido ID", "Entrega ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, horaPedido, clienteId, numeroPedido, carrinhoId, dataPedido, statusPedidoId, entregaId};
    }
}
