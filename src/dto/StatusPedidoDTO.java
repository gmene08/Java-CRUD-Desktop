package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.StatusPedido;

public class StatusPedidoDTO extends InterfaceDTO {
    public String id;
    public String pedidoId;
    public String progresso;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        StatusPedido statusPedido = (StatusPedido) e;
        id = String.valueOf(statusPedido.getId());
        pedidoId = String.valueOf(statusPedido.getPedidoId());
        progresso = statusPedido.getProgresso();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        StatusPedido statusPedido = new StatusPedido();
        statusPedido.setId(Integer.parseInt(id));
        statusPedido.setPedidoId(Integer.parseInt(pedidoId));
        statusPedido.setProgresso(progresso);
        return statusPedido;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Pedido ID", "Progresso"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, pedidoId, progresso};
    }
}
