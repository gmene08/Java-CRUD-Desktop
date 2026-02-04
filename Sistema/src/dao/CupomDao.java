package dao;

import java.sql.SQLException;
import java.util.List;
import model.Cupom;

public interface CupomDao {
    public void salvar(Cupom cupom);
    public void editar (Cupom cupom);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
