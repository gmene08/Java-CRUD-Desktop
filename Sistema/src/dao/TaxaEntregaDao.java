package dao;

import java.sql.SQLException;
import java.util.List;
import model.TaxaEntrega;

public interface TaxaEntregaDao {
    public void salvar(TaxaEntrega taxaEntrega);
    public void editar (TaxaEntrega taxaEntrega);
    public void remover (int id);
    public List listarTodos() throws SQLException;
}
