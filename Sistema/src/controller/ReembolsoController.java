package controller;

import dao.ReembolsoDao;
import dto.ReembolsoDTO;
import implementsDao.ReembolsoImplements;
import java.sql.SQLException;
import java.util.List;
import model.Reembolso;

public class ReembolsoController {

    public void salvar(ReembolsoDTO dto) throws SQLException {
        ReembolsoDao dao = new ReembolsoImplements();
        dao.salvar(dto.builder());
    }

    public void editar(ReembolsoDTO dto) throws SQLException {
        ReembolsoDao dao = new ReembolsoImplements();
        dao.editar(dto.builder());
    }

    public void remover(ReembolsoDTO dto) throws SQLException {
        ReembolsoDao dao = new ReembolsoImplements();
        dao.remover(dto.builder().getId());
    }

    public List<Reembolso> listar() throws SQLException {
        ReembolsoDao dao = new ReembolsoImplements();
        return dao.listarTodos();
    }
}
