package dao;

import java.sql.SQLException;
import java.util.List;
import model.Pedido;

public interface PedidoDao {
    public void salvar(Pedido pedido);
    public void editar (Pedido pedido);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
