package dao;

import java.sql.SQLException;
import java.util.List;
import model.IngredienteEscolha;

public interface IngredienteEscolhaDao {
    public void salvar(IngredienteEscolha ingredienteEscolha);
    public void editar(IngredienteEscolha ingredienteEscolha);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
