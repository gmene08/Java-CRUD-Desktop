package controller;

import dao.MetPagamentoDao;
import dto.MetPagamentoDTO;
import implementsDao.MetPagamentoImplements;
import java.sql.SQLException;
import java.util.List;
import model.MetPagamento;

public class MetPagamentoController {

    public void salvar(MetPagamentoDTO dto) throws SQLException {
        MetPagamentoDao dao = new MetPagamentoImplements();
        dao.salvar(dto.builder());
    }

    public void editar(MetPagamentoDTO dto) throws SQLException {
        MetPagamentoDao dao = new MetPagamentoImplements();
        dao.editar(dto.builder());
    }

    public void remover(MetPagamentoDTO dto) throws SQLException {
        MetPagamentoDao dao = new MetPagamentoImplements();
        dao.remover(dto.builder().getId());
    }

    public List<MetPagamento> listar() throws SQLException {
        MetPagamentoDao dao = new MetPagamentoImplements();
        return dao.listarTodos();
    }
}
