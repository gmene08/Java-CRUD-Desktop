package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.IngredienteRemover;

public class IngredienteRemoverDTO extends InterfaceDTO {
    public String id;
    public String nome;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        IngredienteRemover ingredienteRemover = (IngredienteRemover) e;
        id = String.valueOf(ingredienteRemover.getId());
        nome = ingredienteRemover.getNome();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        IngredienteRemover ingredienteRemover = new IngredienteRemover();
        ingredienteRemover.setId(Integer.parseInt(id));
        ingredienteRemover.setNome(nome);
        return ingredienteRemover;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, nome};
    }
}
