package dto;

import model.IngredienteEscolha;

public class IngredienteEscolhaDTO {
    public String id;
    public String ingredienteEscolhaId;
    public String ingredienteRemoverId;

    public IngredienteEscolha builder() {
        IngredienteEscolha i = new IngredienteEscolha();
        i.setId(id == null ? 0 : Integer.parseInt(id));
        i.setIngredienteEscolhaId(ingredienteEscolhaId == null || ingredienteEscolhaId.isEmpty() ? null : Integer.parseInt(ingredienteEscolhaId));
        i.setIngredienteRemoverId(ingredienteRemoverId == null || ingredienteRemoverId.isEmpty() ? null : Integer.parseInt(ingredienteRemoverId));
        return i;
    }
}
