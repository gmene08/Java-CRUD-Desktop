package controller;

import dao.TelefoneDao;
import dto.TelefoneDTO;
import implementsDao.TelefoneImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Telefone;

public class TelefoneController extends InterfaceController {

    private TelefoneDao dao;

    public TelefoneController() {
        dao = new TelefoneImplements();
        dto = new TelefoneDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(TelefoneController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao salvar o Telefone", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(TelefoneController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao editar o Telefone", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Telefone.class)
            );
        } catch (Exception ex) {
            System.getLogger(TelefoneController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao listar os Telefones", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        try {
            dao.remover(new Telefone(id));
            return true;
        } catch (Exception ex) {
            System.getLogger(TelefoneController.class.getName()).log(System.Logger.Level.ERROR, "Erro ao remover o Telefone", ex);
            return false;
        }
    }
}
