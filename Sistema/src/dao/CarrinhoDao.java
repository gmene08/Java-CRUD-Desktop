package dao;

import java.sql.SQLException;
import java.util.List;
import model.Carrinho;

public interface CarrinhoDao {
    public void salvar(Carrinho carrinho);
    public void editar(Carrinho carrinho);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
