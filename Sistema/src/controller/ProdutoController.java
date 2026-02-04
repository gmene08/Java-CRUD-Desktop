package controller;

import dao.ProdutoDao;
import dto.InterfaceDTO;
import dto.ProdutoDTO;
import implementsDao.ProdutoImplements;
import java.sql.SQLException;
import java.util.List;
import model.Produto;

public class ProdutoController extends InterfaceController{

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        ProdutoDao dao = new ProdutoImplements();
        dao.salvar(((ProdutoDTO)dto).builder());
    }

    public void editar(ProdutoDTO dto) throws SQLException {
        ProdutoDao dao = new ProdutoImplements();
        dao.editar(dto.builder());
    }

    public void remover(ProdutoDTO dto) throws SQLException {
        ProdutoDao dao = new ProdutoImplements();
        dao.remover(dto.builder().getId());
    }

    public List<Produto> listar() throws SQLException {
        ProdutoDao dao = new ProdutoImplements();
        return dao.listarTodos();
    }
}
