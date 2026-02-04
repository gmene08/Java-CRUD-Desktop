package dto;

import model.MetPagamento;

public class MetPagamentoDTO {
    public String id;
    public String dinheiroId;
    public String cartaoId;

    public MetPagamento builder() {
        MetPagamento m = new MetPagamento();
        m.setId(id == null ? 0 : Integer.parseInt(id));
        m.setDinheiroId(dinheiroId == null || dinheiroId.isEmpty() ? null : Integer.valueOf(dinheiroId));
        m.setCartaoId(cartaoId == null || cartaoId.isEmpty() ? null : Integer.valueOf(cartaoId));
        return m;
    }
}
