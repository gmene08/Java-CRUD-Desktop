package controller;

import dao.ClienteDao;
import dto.ClienteDTO;
import dto.InterfaceDTO;
import implementsDao.ClienteImplements;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;

public class ClienteController extends InterfaceController{
    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        ClienteDao dao = new ClienteImplements();
        dao.salvar(((ClienteDTO)dto).builder());
    }

    public List<Cliente> listar() throws SQLException {
        ClienteDao dao = new ClienteImplements();
        return dao.listarTodos();
    }

    public void editar(ClienteDTO clienteDto) throws SQLException {
        ClienteDao dao = new ClienteImplements();
        dao.editar(clienteDto.builder());
    }

    public void remover(ClienteDTO clienteDto) throws SQLException {
        ClienteDao dao = new ClienteImplements();
        dao.remover(clienteDto.builder().getId());
    }

}
