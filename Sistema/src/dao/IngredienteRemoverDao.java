package dao;

import java.sql.SQLException;
import java.util.List;
import model.IngredienteRemover;

public interface IngredienteRemoverDao {
    public void salvar(IngredienteRemover ingredienteRemover);
    public void editar(IngredienteRemover ingredienteRemover);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
