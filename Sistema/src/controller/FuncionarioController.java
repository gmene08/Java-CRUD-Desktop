package controller;

import dao.FuncionarioDao;
import dto.FuncionarioDTO;
import dto.InterfaceDTO;
import implementsDao.FuncionarioImplements;
import java.sql.SQLException;
import java.util.List;
import model.Funcionario;

public class FuncionarioController extends InterfaceController{

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        FuncionarioDao dao = new FuncionarioImplements();
        dao.salvar(((FuncionarioDTO)dto).builder());
    }

    public void editar(FuncionarioDTO funcionarioDTO) throws SQLException {
        FuncionarioDao dao = new FuncionarioImplements();
        dao.editar(funcionarioDTO.builder());
    }

    public void remover(FuncionarioDTO funcionarioDTO) throws SQLException {
        FuncionarioDao dao = new FuncionarioImplements();
        dao.remover(funcionarioDTO.builder().getId());
    }

    public List<Funcionario> listar() throws SQLException {
        FuncionarioDao dao = new FuncionarioImplements();
        return dao.listarTodos();
    }
}
