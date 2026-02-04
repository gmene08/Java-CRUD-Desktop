package dao;

import java.sql.SQLException;
import java.util.List;
import model.IngredienteAdicional;

public interface IngredienteAdicionalDao {
    public void salvar(IngredienteAdicional ingredienteAdicional);
    public void editar(IngredienteAdicional ingredienteAdicional);
    public void remover( int id);
    public List listarTodos() throws SQLException;
}
