package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Cupom;

public class CupomDTO extends InterfaceDTO {
    public Integer idCupom;
    public String valorCupom;
    public String codigo;
    public String validade;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Cupom c = (Cupom) e;

        idCupom = c.getId();
        valorCupom = String.valueOf(c.getValorCupom());
        codigo = c.getCodigo();
        validade = c.getValidade();
        
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Cupom c = new Cupom();
        
        c.setId(idCupom != null ? idCupom : 0);  
        c.setValorCupom(valorCupom != null && !valorCupom.isEmpty() ? Double.parseDouble(valorCupom) : 0.0);
        c.setCodigo(codigo);
        c.setValidade(validade);
        
        return c;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Código", "Valor", "Validade"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idCupom, codigo, valorCupom, validade};
    }
}
