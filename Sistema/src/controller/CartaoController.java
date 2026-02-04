package controller;

import dao.CartaoDao;
import dto.CartaoDTO;
import implementsDao.CartaoImplements;
import java.sql.SQLException;
import java.util.List;
import model.Cartao;

public class CartaoController {

    public void salvar(CartaoDTO cartaoDTO) throws SQLException {
        CartaoDao dao = new CartaoImplements();
        dao.salvar(cartaoDTO.builder());
    }

    public void editar(CartaoDTO cartaoDTO) throws SQLException {
        CartaoDao dao = new CartaoImplements();
        dao.editar(cartaoDTO.builder());
    }

    public void remover(CartaoDTO cartaoDTO) throws SQLException {
        CartaoDao dao = new CartaoImplements();
        dao.remover(cartaoDTO.builder().getId());
    }

    public List<Cartao> listar() throws SQLException {
        CartaoDao dao = new CartaoImplements();
        return dao.listarTodos();
    }
}