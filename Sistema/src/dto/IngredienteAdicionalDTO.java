package dto;

import model.IngredienteAdicional;

public class IngredienteAdicionalDTO {
    public String idIngrediente;
    public String nome;
    public String valor;

    public IngredienteAdicional builder() {
        IngredienteAdicional i = new IngredienteAdicional();
        i.setId(idIngrediente == null ? 0 : Integer.parseInt(idIngrediente));
        i.setNome(nome);
        i.setValor(valor == null ? 0 : Double.parseDouble(valor));
        return i;
    }
}
