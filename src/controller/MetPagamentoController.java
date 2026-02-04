package controller;

import dao.MetPagamentoDao;
import dto.MetPagamentoDTO;
import implementsDao.MetPagamentoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.MetPagamento;

public class MetPagamentoController extends InterfaceController {

    private MetPagamentoDao dao;

    public MetPagamentoController() {
        dao = new MetPagamentoImplements();
        dto = new MetPagamentoDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(MetPagamentoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(MetPagamentoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(MetPagamento.class)
            );
        } catch (Exception ex) {
            System.getLogger(MetPagamentoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new MetPagamento(id));
        return true;
    }
}
