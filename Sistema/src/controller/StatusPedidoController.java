package controller;

import dao.StatusPedidoDao;
import dto.StatusPedidoDTO;
import implementsDao.StatusPedidoImplements;
import java.sql.SQLException;
import java.util.List;
import model.StatusPedido;

public class StatusPedidoController {

    public void salvar(StatusPedidoDTO dto) throws SQLException {
        StatusPedidoDao dao = new StatusPedidoImplements();
        dao.salvar(dto.builder());
    }

    public void editar(StatusPedidoDTO dto) throws SQLException {
        StatusPedidoDao dao = new StatusPedidoImplements();
        dao.editar(dto.builder());
    }

    public void remover(StatusPedidoDTO dto) throws SQLException {
        StatusPedidoDao dao = new StatusPedidoImplements();
        dao.remover(dto.builder().getId());
    }

    public List<StatusPedido> listar() throws SQLException {
        StatusPedidoDao dao = new StatusPedidoImplements();
        return dao.listarTodos();
    }
}
