package dao;

import java.sql.SQLException;
import java.util.List;
import model.Pagamento;

public interface PagamentoDao {
    public void salvar(Pagamento pagamento);
    public void editar (Pagamento pagamento);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
