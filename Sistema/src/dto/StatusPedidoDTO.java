package dto;

import model.StatusPedido;

public class StatusPedidoDTO {
    public String id;
    public String pedidoId;
    public String progresso;

    public StatusPedido builder() {
        StatusPedido sp = new StatusPedido();
        sp.setId(id == null ? 0 : Integer.parseInt(id));
        sp.setPedidoId(pedidoId == null ? 0 : Integer.parseInt(pedidoId));
        sp.setProgresso(progresso);
        return sp;
    }
}
