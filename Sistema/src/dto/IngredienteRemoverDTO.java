package dto;

import model.IngredienteRemover;

public class IngredienteRemoverDTO {
    public String id;
    public String nome;

    public IngredienteRemover builder() {
        IngredienteRemover i = new IngredienteRemover();
        i.setId(id == null ? 0 : Integer.parseInt(id));
        i.setNome(nome);
        return i;
    }
}
