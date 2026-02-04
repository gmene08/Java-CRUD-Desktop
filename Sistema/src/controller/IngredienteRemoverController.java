package controller;

import dao.IngredienteRemoverDao;
import dto.IngredienteRemoverDTO;
import implementsDao.IngredienteRemoverImplements;
import java.sql.SQLException;
import java.util.List;
import model.IngredienteRemover;

public class IngredienteRemoverController {

    public void salvar(IngredienteRemoverDTO dto) throws SQLException {
        IngredienteRemoverDao dao = new IngredienteRemoverImplements();
        dao.salvar(dto.builder());
    }

    public void editar(IngredienteRemoverDTO dto) throws SQLException {
        IngredienteRemoverDao dao = new IngredienteRemoverImplements();
        dao.editar(dto.builder());
    }

    public void remover(IngredienteRemoverDTO dto) throws SQLException {
        IngredienteRemoverDao dao = new IngredienteRemoverImplements();
        dao.remover(dto.builder().getId());
    }

    public List<IngredienteRemover> listar() throws SQLException {
        IngredienteRemoverDao dao = new IngredienteRemoverImplements();
        return dao.listarTodos();
    }
}
