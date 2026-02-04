package dao;

import java.sql.SQLException;
import java.util.List;
import model.Login;

public interface LoginDao {
    public void salvar(Login login);
    public void editar (Login login);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
