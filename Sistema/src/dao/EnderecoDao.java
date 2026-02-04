package dao;

import java.sql.SQLException;
import java.util.List;
import model.Endereco;

public interface EnderecoDao {
    public void salvar(Endereco endereco);
    public void editar(Endereco endereco);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
