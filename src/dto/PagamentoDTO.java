package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Pagamento;

public class PagamentoDTO extends InterfaceDTO {
    public String id;
    public String metPagamentoId;
    public String cupomId;
    public String pedidoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Pagamento pagamento = (Pagamento) e;
        id = String.valueOf(pagamento.getId());
        metPagamentoId = String.valueOf(pagamento.getMetPagamentoId());
        cupomId = String.valueOf(pagamento.getCupomId());
        pedidoId = String.valueOf(pagamento.getPedidoId());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(Integer.parseInt(id));
        pagamento.setMetPagamentoId(Integer.parseInt(metPagamentoId));
        pagamento.setCupomId(Integer.parseInt(cupomId));
        pagamento.setPedidoId(Integer.parseInt(pedidoId));
        return pagamento;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Método de Pagamento ID", "Cupom ID", "Pedido ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, metPagamentoId, cupomId, pedidoId};
    }
}
