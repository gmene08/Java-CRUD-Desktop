package controller;

import dao.EntregaDao;
import dto.EntregaDTO;
import implementsDao.EntregaImplements;
import java.sql.SQLException;
import java.util.List;
import model.Entrega;

public class EntregaController {

    public void salvar(EntregaDTO entregaDTO) throws SQLException {
        EntregaDao dao = new EntregaImplements();
        dao.salvar(entregaDTO.builder());
    }

    public void editar(EntregaDTO entregaDTO) throws SQLException {
        EntregaDao dao = new EntregaImplements();
        dao.editar(entregaDTO.builder());
    }

    public void remover(EntregaDTO entregaDTO) throws SQLException {
        EntregaDao dao = new EntregaImplements();
        dao.remover(entregaDTO.builder().getId());
    }

    public List<Entrega> listar() throws SQLException {
        EntregaDao dao = new EntregaImplements();
        return dao.listarTodos();
    }
}
