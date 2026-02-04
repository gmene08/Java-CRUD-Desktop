package dto;

import model.Dinheiro;
import model.MetPagamento;

public class DinheiroDTO {
    public String idDinheiro;
    public String valorEntregue;
    public String idMetPagamento;

    public Dinheiro builder() {
        Dinheiro d = new Dinheiro();
        d.setId(idDinheiro == null ? 0 : Integer.parseInt(idDinheiro));
        d.setValorEntregue(valorEntregue == null ? 0 : Double.parseDouble(valorEntregue));

        MetPagamento met = new MetPagamento();
        met.setId(idMetPagamento == null ? 0 : Integer.parseInt(idMetPagamento));
        d.setMetPagamento(met);

        return d;
    }
}
