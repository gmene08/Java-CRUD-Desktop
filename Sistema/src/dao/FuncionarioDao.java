package dao;

import java.sql.SQLException;
import java.util.List;
import model.Funcionario;

public interface FuncionarioDao {
    public void salvar(Funcionario funcionario);
    public void editar(Funcionario funcionario);
    public void remover(int id);
    public List listarTodos() throws SQLException;
}
