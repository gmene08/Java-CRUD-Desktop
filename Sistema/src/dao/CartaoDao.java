package dao;

import java.sql.SQLException;
import java.util.List;
import model.Cartao;

public interface CartaoDao {
    public void salvar (Cartao cartao);
    public void editar (Cartao cartao);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
