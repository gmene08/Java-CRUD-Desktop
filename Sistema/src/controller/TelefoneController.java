package controller;

import dao.TelefoneDao;
import dto.TelefoneDTO;
import implementsDao.TelefoneImplements;
import java.sql.SQLException;
import java.util.List;
import model.Telefone;

public class TelefoneController {

    public void salvar(TelefoneDTO dto) throws SQLException {
        TelefoneDao dao = new TelefoneImplements();
        dao.salvar(dto.builder());
    }

    public void editar(TelefoneDTO dto) throws SQLException {
        TelefoneDao dao = new TelefoneImplements();
        dao.editar(dto.builder());
    }

    public void remover(TelefoneDTO dto) throws SQLException {
        TelefoneDao dao = new TelefoneImplements();
        dao.remover(dto.builder().getId());
    }

    public List<Telefone> listar() throws SQLException {
        TelefoneDao dao = new TelefoneImplements();
        return dao.listarTodos();
    }
}
