package controller;

import dao.LoginDao;
import dto.LoginDTO;
import implementsDao.LoginImplements;
import java.sql.SQLException;
import java.util.List;
import model.Login;

public class LoginController {

    public void salvar(LoginDTO dto) throws SQLException {
        LoginDao dao = new LoginImplements();
        dao.salvar(dto.builder());
    }

    public void editar(LoginDTO dto) throws SQLException {
        LoginDao dao = new LoginImplements();
        dao.editar(dto.builder());
    }

    public void remover(LoginDTO dto) throws SQLException {
        LoginDao dao = new LoginImplements();
        dao.remover(dto.builder().getId());
    }

    public List<Login> listar() throws SQLException {
        LoginDao dao = new LoginImplements();
        return dao.listarTodos();
    }
}
