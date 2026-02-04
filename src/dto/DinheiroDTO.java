package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Dinheiro;

public class DinheiroDTO extends InterfaceDTO {
    public String idDinheiro;
    public String valorEntregue;
    public String idMetPagamento;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Dinheiro d = (Dinheiro) e;
        idDinheiro = String.valueOf(d.getId());
        valorEntregue = String.valueOf(d.getValorEntregue());
        idMetPagamento = String.valueOf(d.getMetPagamento() != null ? d.getMetPagamento().getId() : null);
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Dinheiro d = new Dinheiro();
        d.setId(Integer.parseInt(idDinheiro));
        d.setValorEntregue(Double.parseDouble(valorEntregue));
        return d;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Valor Entregue", "Método de Pagamento"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idDinheiro, valorEntregue, idMetPagamento};
    }
}
