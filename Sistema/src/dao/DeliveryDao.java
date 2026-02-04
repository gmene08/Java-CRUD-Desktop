package dao;

import java.sql.SQLException;
import java.util.List;
import model.Delivery;

public interface DeliveryDao {
    public void salvar(Delivery delivery);
    public void editar(Delivery delivery);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
