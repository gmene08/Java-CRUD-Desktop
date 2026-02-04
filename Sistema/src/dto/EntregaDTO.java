package dto;

import model.Entrega;

public class EntregaDTO {
    public String idEntrega;
    public String tipoEntrega;
    public String statusPedidoId;

    public Entrega builder() {
        Entrega e = new Entrega();
        e.setId(idEntrega == null ? 0 : Integer.parseInt(idEntrega));
        e.setTipoEntrega(tipoEntrega);
        e.setStatusPedidoId(statusPedidoId == null ? 0 : Integer.parseInt(statusPedidoId));
        return e;
    }
}
