package controller;

import dao.CupomDao;
import dto.CupomDTO;
import implementsDao.CupomImplements;
import java.sql.SQLException;
import java.util.List;
import model.Cupom;

public class CupomController {

    public void salvar(CupomDTO cupomDTO) throws SQLException {
        CupomDao dao = new CupomImplements();
        dao.salvar(cupomDTO.builder());
    }

    public void editar(CupomDTO cupomDTO) throws SQLException {
        CupomDao dao = new CupomImplements();
        dao.editar(cupomDTO.builder());
    }

    public void remover(CupomDTO cupomDTO) throws SQLException {
        CupomDao dao = new CupomImplements();
        dao.remover(cupomDTO.builder().getId());
    }

    public List<Cupom> listar() throws SQLException {
        CupomDao dao = new CupomImplements();
        return dao.listarTodos();
    }
}
