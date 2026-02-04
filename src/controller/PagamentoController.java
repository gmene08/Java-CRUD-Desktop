package controller;

import dao.PagamentoDao;
import dto.PagamentoDTO;
import implementsDao.PagamentoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Pagamento;

public class PagamentoController extends InterfaceController {

    private PagamentoDao dao;

    public PagamentoController() {
        dao = new PagamentoImplements();
        dto = new PagamentoDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(PagamentoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(PagamentoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Pagamento.class)
            );
        } catch (Exception ex) {
            System.getLogger(PagamentoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Pagamento(id));
        return true;
    }
}
