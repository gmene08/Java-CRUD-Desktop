package dao;

import java.sql.SQLException;
import java.util.List;
import model.Cliente;

public interface ClienteDao {
    public void salvar(Cliente cliente);
    public void editar (Cliente cliente);
    public void remover (int id);
    public List listarTodos() throws SQLException;
    
}
