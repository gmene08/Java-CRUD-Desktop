package controller;

import dao.EnderecoDao;
import dto.EnderecoDTO;
import implementsDao.EnderecoImplements;
import java.sql.SQLException;
import java.util.List;
import model.Endereco;

public class EnderecoController {

    public void salvar(EnderecoDTO enderecoDTO) throws SQLException {
        EnderecoDao dao = new EnderecoImplements();
        dao.salvar(enderecoDTO.builder());
    }

    public void editar(EnderecoDTO enderecoDTO) throws SQLException {
        EnderecoDao dao = new EnderecoImplements();
        dao.editar(enderecoDTO.builder());
    }

    public void remover(EnderecoDTO enderecoDTO) throws SQLException {
        EnderecoDao dao = new EnderecoImplements();
        dao.remover(enderecoDTO.builder().getId());
    }

    public List<Endereco> listar() throws SQLException {
        EnderecoDao dao = new EnderecoImplements();
        return dao.listarTodos();
    }
}
