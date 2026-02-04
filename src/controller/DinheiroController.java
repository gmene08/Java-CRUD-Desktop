package controller;

import dao.DinheiroDao;
import dto.DinheiroDTO;
import implementsDao.DinheiroImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Dinheiro;

public class DinheiroController extends InterfaceController {

    private DinheiroDao dao;

    public DinheiroController() {
        dao = new DinheiroImplements();
        dto = new DinheiroDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Dinheiro.class)
            );
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Dinheiro(id));
        return true;
    }
}
