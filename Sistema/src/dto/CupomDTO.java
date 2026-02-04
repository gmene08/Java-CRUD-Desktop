package dto;

import model.Cupom;

public class CupomDTO {
    public String idCupom;
    public String valorCupom;
    public String codigo;
    public String validade;

    public Cupom builder() {
        Cupom c = new Cupom();
        c.setId(idCupom == null ? 0 : Integer.parseInt(idCupom));
        c.setValorCupom(valorCupom == null ? 0.0 : Double.parseDouble(valorCupom));
        c.setCodigo(codigo);
        c.setValidade(validade);
        return c;
    }
}
