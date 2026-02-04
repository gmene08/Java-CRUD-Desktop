package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Cartao;

public class CartaoDTO extends InterfaceDTO {
    public Integer idCartao;
    public String numCartao;
    public String cvv;
    public Integer tipo; 

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Cartao c = (Cartao) e;
        numCartao = c.getNumCartao();
        cvv = c.getCvv();
        tipo = c.getTipo();
        id = c.getId() + ""; 
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Cartao c = new Cartao();
        c.setId(Integer.parseInt(id)); 
        c.setNumCartao(numCartao);
        c.setCvv(cvv);
        c.setTipo(tipo);
        return c;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Número do Cartão", "CVV", "Tipo"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idCartao, numCartao, cvv, tipo};
    }
}
