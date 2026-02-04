package controller;

import dao.ReembolsoDao;
import dto.ReembolsoDTO;
import implementsDao.ReembolsoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Reembolso;

public class ReembolsoController extends InterfaceController {

    private ReembolsoDao dao;

    public ReembolsoController() {
        dao = new ReembolsoImplements();
        dto = new ReembolsoDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Reembolso.class)
            );
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Reembolso(id));
        return true;
    }
}
