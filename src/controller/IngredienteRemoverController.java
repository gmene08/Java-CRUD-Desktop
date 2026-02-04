package controller;

import dao.IngredienteRemoverDao;
import dto.IngredienteRemoverDTO;
import implementsDao.IngredienteRemoverImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.IngredienteRemover;

public class IngredienteRemoverController extends InterfaceController {

    private IngredienteRemoverDao dao;

    public IngredienteRemoverController() {
        dao = new IngredienteRemoverImplements();
        dto = new IngredienteRemoverDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(IngredienteRemover.class)
            );
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new IngredienteRemover(id));
        return true;
    }
}
