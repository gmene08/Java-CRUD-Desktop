package dao;

import java.util.List;
import java.sql.SQLException;
import model.Bairro;

public interface BairroDao {
    public void salvar(Bairro bairro);
    public void editar(Bairro bairro);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
