package controller;

import dao.PagamentoDao;
import dto.PagamentoDTO;
import implementsDao.PagamentoImplements;
import java.sql.SQLException;
import java.util.List;
import model.Pagamento;

public class PagamentoController {

    public void salvar(PagamentoDTO dto) throws SQLException {
        PagamentoDao dao = new PagamentoImplements();
        dao.salvar(dto.builder());
    }

    public void editar(PagamentoDTO dto) throws SQLException {
        PagamentoDao dao = new PagamentoImplements();
        dao.editar(dto.builder());
    }

    public void remover(PagamentoDTO dto) throws SQLException {
        PagamentoDao dao = new PagamentoImplements();
        dao.remover(dto.builder().getId());
    }

    public List<Pagamento> listar() throws SQLException {
        PagamentoDao dao = new PagamentoImplements();
        return dao.listarTodos();
    }
}
