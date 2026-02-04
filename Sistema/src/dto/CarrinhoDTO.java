package dto;

import model.Carrinho;

public class CarrinhoDTO {
    public String idCarrinho;
    public int quantCarinho;
    
    public Carrinho builder(){
        Carrinho c = new Carrinho();
        c.setId(idCarrinho==null?0:Integer.parseInt(idCarrinho));
        c.setQuantidade(quantCarinho);
        return c;
    }
}
