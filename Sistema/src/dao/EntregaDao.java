package dao;

import java.sql.SQLException;
import java.util.List;
import model.Entrega;

public interface EntregaDao {
    public void salvar(Entrega entrega);
    public void editar(Entrega entrega);
    public void remover(int id);
    public List listarTodos()  throws SQLException;
}
