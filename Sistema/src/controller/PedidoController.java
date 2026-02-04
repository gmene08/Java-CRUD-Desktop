package controller;

import dao.PedidoDao;
import dto.PedidoDTO;
import implementsDao.PedidoImplements;
import java.sql.SQLException;
import java.util.List;
import model.Pedido;

public class PedidoController {

    public void salvar(PedidoDTO dto) throws SQLException {
        PedidoDao dao = new PedidoImplements();
        dao.salvar(dto.builder());
    }

    public void editar(PedidoDTO dto) throws SQLException {
        PedidoDao dao = new PedidoImplements();
        dao.editar(dto.builder());
    }

    public void remover(PedidoDTO dto) throws SQLException {
        PedidoDao dao = new PedidoImplements();
        dao.remover(dto.builder().getId());
    }

    public List<Pedido> listar() throws SQLException {
        PedidoDao dao = new PedidoImplements();
        return dao.listarTodos();
    }
}
