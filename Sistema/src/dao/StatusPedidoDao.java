package dao;

import java.sql.SQLException;
import java.util.List;
import model.StatusPedido;

public interface StatusPedidoDao {
    public void salvar(StatusPedido statusPedido);
    public void editar (StatusPedido statusPedido);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
