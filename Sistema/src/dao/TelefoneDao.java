package dao;

import java.sql.SQLException;
import java.util.List;
import model.Telefone;

public interface TelefoneDao {
    public void salvar(Telefone telefone);
    public void editar (Telefone telefone);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
