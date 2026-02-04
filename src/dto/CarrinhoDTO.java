package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Carrinho;

public class CarrinhoDTO extends InterfaceDTO {
    public Integer idCarrinho; 
    public int quantCarinho;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Carrinho c = (Carrinho) e;
        
        quantCarinho = c.getQuantidade();
        idCarrinho = c.getId();  
        
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Carrinho c = new Carrinho();
        
        c.setId(idCarrinho != null ? idCarrinho : 0); 
        c.setQuantidade(quantCarinho);
        
        return c;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Quantidade"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idCarrinho, quantCarinho};
    }
}
