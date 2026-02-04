package dto;

import model.Reembolso;

public class ReembolsoDTO {
    public String id;
    public String pedidoId;
    public String motivo;

    public Reembolso builder() {
        Reembolso r = new Reembolso();
        r.setId(id == null ? 0 : Integer.parseInt(id));
        r.setPedidoId(pedidoId == null ? 0 : Integer.parseInt(pedidoId));
        r.setMotivo(motivo);
        return r;
    }
}
