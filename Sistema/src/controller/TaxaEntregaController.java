package controller;

import dao.TaxaEntregaDao;
import dto.TaxaEntregaDTO;
import implementsDao.TaxaEntregaImplements;
import java.sql.SQLException;
import java.util.List;
import model.TaxaEntrega;

public class TaxaEntregaController {

    public void salvar(TaxaEntregaDTO dto) throws SQLException {
        TaxaEntregaDao dao = new TaxaEntregaImplements();
        dao.salvar(dto.builder());
    }

    public void editar(TaxaEntregaDTO dto) throws SQLException {
        TaxaEntregaDao dao = new TaxaEntregaImplements();
        dao.editar(dto.builder());
    }

    public void remover(TaxaEntregaDTO dto) throws SQLException {
        TaxaEntregaDao dao = new TaxaEntregaImplements();
        dao.remover(dto.builder().getId());
    }

    public List<TaxaEntrega> listar() throws SQLException {
        TaxaEntregaDao dao = new TaxaEntregaImplements();
        return dao.listarTodos();
    }
}
