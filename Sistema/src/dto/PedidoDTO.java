package dto;

import model.Pedido;

public class PedidoDTO {
    public String id;
    public String horaPedido;
    public String clienteId;
    public String numeroPedido;
    public String carrinhoId;
    public String dataPedido;
    public String statusPedidoId;
    public String entregaId;

    public Pedido builder() {
        Pedido p = new Pedido();
        p.setId(id == null ? 0 : Integer.parseInt(id));
        p.setHoraPedido(horaPedido);
        p.setClienteId(clienteId == null ? 0 : Integer.parseInt(clienteId));
        p.setNumeroPedido(numeroPedido);
        p.setCarrinhoId(carrinhoId == null ? 0 : Integer.parseInt(carrinhoId));
        p.setDataPedido(dataPedido);
        p.setStatusPedidoId(statusPedidoId == null ? 0 : Integer.parseInt(statusPedidoId));
        p.setEntregaId(entregaId == null ? 0 : Integer.parseInt(entregaId));
        return p;
    }
}
