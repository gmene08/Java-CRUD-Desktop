package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.IngredienteEscolha;

public class IngredienteEscolhaDTO extends InterfaceDTO {
    public String id;
    public String ingredienteEscolhaId;
    public String ingredienteRemoverId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        IngredienteEscolha ingredienteEscolha = (IngredienteEscolha) e;
        id = String.valueOf(ingredienteEscolha.getId());
        ingredienteEscolhaId = String.valueOf(ingredienteEscolha.getIngredienteEscolhaId());
        ingredienteRemoverId = String.valueOf(ingredienteEscolha.getIngredienteRemoverId());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
        ingredienteEscolha.setId(Integer.parseInt(id));
        ingredienteEscolha.setIngredienteEscolhaId(Integer.parseInt(ingredienteEscolhaId));
        ingredienteEscolha.setIngredienteRemoverId(Integer.parseInt(ingredienteRemoverId));
        return ingredienteEscolha;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Ingrediente Escolha ID", "Ingrediente Remover ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, ingredienteEscolhaId, ingredienteRemoverId};
    }
}
