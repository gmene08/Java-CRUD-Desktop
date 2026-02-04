package dto;

import model.Cartao;

public class CartaoDTO {
    public String idCartao;
    public String numCartao;
    public String cvv;
    public String tipo;  
    
    public Cartao builder() {
        Cartao c = new Cartao();
        c.setId(idCartao == null ? 0 : Integer.parseInt(idCartao));
        c.setNumCartao(numCartao);
        c.setCvv(cvv);
        c.setTipo(tipo == null ? 0 : Integer.parseInt(tipo)); 
        return c;
    }
}