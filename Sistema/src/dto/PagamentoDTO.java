package dto;

import model.Pagamento;

public class PagamentoDTO {
    public String id;
    public String metPagamentoId;
    public String cupomId;
    public String pedidoId;

    public Pagamento builder() {
        Pagamento p = new Pagamento();
        p.setId(id == null ? 0 : Integer.parseInt(id));
        p.setMetPagamentoId(metPagamentoId == null ? 0 : Integer.parseInt(metPagamentoId));
        p.setCupomId(cupomId == null ? 0 : Integer.parseInt(cupomId));
        p.setPedidoId(pedidoId == null ? 0 : Integer.parseInt(pedidoId));
        return p;
    }
}
