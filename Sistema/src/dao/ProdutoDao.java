package dao;

import java.sql.SQLException;
import java.util.List;
import model.Produto;

public interface ProdutoDao {
    public void salvar(Produto produto);
    public void editar (Produto produto);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
