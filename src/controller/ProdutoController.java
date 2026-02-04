package controller;

import dao.ProdutoDao;
import dto.ProdutoDTO;
import implementsDao.ProdutoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Produto;

public class ProdutoController extends InterfaceController {

    private ProdutoDao dao;

    public ProdutoController() {
        dao = new ProdutoImplements();
        dto = new ProdutoDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Produto.class)
            );
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Produto(id));
        return true;
    }
}
