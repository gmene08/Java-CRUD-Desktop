package dao;

import java.sql.SQLException;
import java.util.List;
import model.Dinheiro;

public interface DinheiroDao {
    public void salvar(Dinheiro dinheiro);
    public void editar(Dinheiro dinheiro);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
