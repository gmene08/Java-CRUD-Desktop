package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Produto;

public class ProdutoDTO extends InterfaceDTO {
    public String id;
    public String nome;
    public String valorUnitario;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Produto produto = (Produto) e;
        id = String.valueOf(produto.getId());
        nome = produto.getNome();
        valorUnitario = String.valueOf(produto.getValorUnitario());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(id));
        produto.setNome(nome);
        produto.setValorUnitario(Double.parseDouble(valorUnitario));
        return produto;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome", "Valor Unitário"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, nome, valorUnitario};
    }
}
