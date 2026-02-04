package controller;

import dao.EnderecoDao;
import dto.EnderecoDTO;
import implementsDao.EnderecoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Endereco;

public class EnderecoController extends InterfaceController {

    private EnderecoDao dao;

    public EnderecoController() {
        dao = new EnderecoImplements();
        dto = new EnderecoDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Endereco.class)
            );
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Endereco(id));
        return true;
    }
}
