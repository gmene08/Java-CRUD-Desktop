package controller;

import dao.TaxaEntregaDao;
import dto.TaxaEntregaDTO;
import implementsDao.TaxaEntregaImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.TaxaEntrega;

public class TaxaEntregaController extends InterfaceController {

    private TaxaEntregaDao dao;

    public TaxaEntregaController() {
        dao = new TaxaEntregaImplements();
        dto = new TaxaEntregaDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao salvar a TaxaEntrega", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao editar a TaxaEntrega", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(TaxaEntrega.class)
            );
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao listar as TaxaEntrega", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        try {
            dao.remover(new TaxaEntrega(id));
            return true;
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao remover a TaxaEntrega", ex);
            return false;
        }
    }
}
