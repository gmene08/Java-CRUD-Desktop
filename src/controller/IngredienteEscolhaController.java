package controller;

import dao.IngredienteEscolhaDao;
import dto.IngredienteEscolhaDTO;
import implementsDao.IngredienteEscolhaImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.IngredienteEscolha;

public class IngredienteEscolhaController extends InterfaceController {

    private IngredienteEscolhaDao dao;

    public IngredienteEscolhaController() {
        dao = new IngredienteEscolhaImplements();
        dto = new IngredienteEscolhaDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(IngredienteEscolha.class)
            );
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new IngredienteEscolha(id));
        return true;
    }
}
