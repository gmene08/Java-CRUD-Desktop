package controller;

import dao.BairroDao;
import dto.BairroDTO;
import dto.InterfaceDTO;
import implementsDao.BairroImplements;
import java.sql.SQLException;
import java.util.List;
import model.Bairro;

public class BairroController extends InterfaceController{

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException{
        BairroDao dao = new BairroImplements();
        dao.salvar(((BairroDTO)dto).builder());
    }

    public void editar(BairroDTO bairroDTO) throws SQLException {
        BairroDao dao = new BairroImplements();
        dao.editar(bairroDTO.builder());
    }

    public void remover(BairroDTO bairroDTO) throws SQLException {
        BairroDao dao = new BairroImplements();
        dao.remover(bairroDTO.builder().getId());
    }

    public List<Bairro> listar() throws SQLException {
        BairroDao dao = new BairroImplements();
        return dao.listarTodos();
    }
}
