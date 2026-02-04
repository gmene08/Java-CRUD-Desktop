package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.MetPagamento;

public class MetPagamentoDTO extends InterfaceDTO {
    public String id;
    public String dinheiroId;
    public String cartaoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        MetPagamento metPagamento = (MetPagamento) e;
        id = String.valueOf(metPagamento.getId());
        dinheiroId = String.valueOf(metPagamento.getDinheiroId());
        cartaoId = String.valueOf(metPagamento.getCartaoId());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        MetPagamento metPagamento = new MetPagamento();
        metPagamento.setId(Integer.parseInt(id));
        metPagamento.setDinheiroId(Integer.parseInt(dinheiroId));
        metPagamento.setCartaoId(Integer.parseInt(cartaoId));
        return metPagamento;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Dinheiro ID", "Cartão ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, dinheiroId, cartaoId};
    }
}
