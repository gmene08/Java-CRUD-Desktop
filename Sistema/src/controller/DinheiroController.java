package controller;

import dao.DinheiroDao;
import dto.DinheiroDTO;
import implementsDao.DinheiroImplements;
import java.sql.SQLException;
import java.util.List;
import model.Dinheiro;

public class DinheiroController {

    public void salvar(DinheiroDTO dinheiroDTO) throws SQLException {
        DinheiroDao dao = new DinheiroImplements();
        dao.salvar(dinheiroDTO.builder());
    }

    public void editar(DinheiroDTO dinheiroDTO) throws SQLException {
        DinheiroDao dao = new DinheiroImplements();
        dao.editar(dinheiroDTO.builder());
    }

    public void remover(DinheiroDTO dinheiroDTO) throws SQLException {
        DinheiroDao dao = new DinheiroImplements();
        dao.remover(dinheiroDTO.builder().getId());
    }

    public List<Dinheiro> listar() throws SQLException {
        DinheiroDao dao = new DinheiroImplements();
        return dao.listarTodos();
    }
}
