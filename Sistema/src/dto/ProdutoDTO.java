package dto;

import model.Produto;

public class ProdutoDTO extends InterfaceDTO{
    public String id;
    public String nome;
    public String valorUnitario;

    public Produto builder() {
        Produto p = new Produto();
        p.setId(id == null ? 0 : Integer.parseInt(id));
        p.setNome(nome);
        p.setValorUnitario(valorUnitario == null ? 0.0 : Double.parseDouble(valorUnitario));
        return p;
    }
}

