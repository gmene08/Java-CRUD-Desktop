package dao;

import java.sql.SQLException;
import java.util.List;
import model.Reembolso;

public interface ReembolsoDao {
    public void salvar(Reembolso reembolso);
    public void editar (Reembolso reembolso);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
