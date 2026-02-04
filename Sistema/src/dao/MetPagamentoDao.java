package dao;

import java.sql.SQLException;
import java.util.List;
import model.MetPagamento;

public interface MetPagamentoDao {
    public void salvar(MetPagamento metPagamento);
    public void editar (MetPagamento metPagamento);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
