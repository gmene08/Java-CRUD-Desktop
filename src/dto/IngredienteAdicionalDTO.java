package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.IngredienteAdicional;

public class IngredienteAdicionalDTO extends InterfaceDTO {
    public String idIngrediente;
    public String nome;
    public String valor;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        IngredienteAdicional ingrediente = (IngredienteAdicional) e;
        idIngrediente = String.valueOf(ingrediente.getId());
        nome = ingrediente.getNome();
        valor = String.valueOf(ingrediente.getValor());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        IngredienteAdicional ingrediente = new IngredienteAdicional();
        ingrediente.setId(Integer.parseInt(idIngrediente));
        ingrediente.setNome(nome);
        ingrediente.setValor(Double.parseDouble(valor));
        return ingrediente;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome", "Valor"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idIngrediente, nome, valor};
    }
}
