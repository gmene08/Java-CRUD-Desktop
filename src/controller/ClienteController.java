package controller;

import dao.ClienteDao;
import dto.ClienteDTO;
import implementsDao.ClienteImplements;
import interfaces.Entidade;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Cliente;

public class ClienteController extends InterfaceController{

    private ClienteDao dao;
    
    public ClienteController(){
        dao = new ClienteImplements();
        dto = new ClienteDTO();
    }
    
    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List<Entidade> entidades = dao.listarTodos(Cliente.class);
            List<InterfaceDTO> dtos = dto.preencheLista(entidades);
            return dtos;
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
}

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Cliente(id));
           return true;
    }
}
