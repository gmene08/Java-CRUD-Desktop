package controller;

import dao.FuncionarioDao;
import dto.FuncionarioDTO;
import implementsDao.FuncionarioImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Funcionario;

public class FuncionarioController extends InterfaceController {

    private FuncionarioDao dao;

    public FuncionarioController() {
        dao = new FuncionarioImplements();
        dto = new FuncionarioDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Funcionario.class)
            );
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Funcionario(id));
        return true;
    }
}
