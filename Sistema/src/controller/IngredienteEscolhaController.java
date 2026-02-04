package controller;

import dao.IngredienteEscolhaDao;
import dto.IngredienteEscolhaDTO;
import implementsDao.IngredienteEscolhaImplements;
import java.sql.SQLException;
import java.util.List;
import model.IngredienteEscolha;

public class IngredienteEscolhaController {

    public void salvar(IngredienteEscolhaDTO dto) throws SQLException {
        IngredienteEscolhaDao dao = new IngredienteEscolhaImplements();
        dao.salvar(dto.builder());
    }

    public void editar(IngredienteEscolhaDTO dto) throws SQLException {
        IngredienteEscolhaDao dao = new IngredienteEscolhaImplements();
        dao.editar(dto.builder());
    }

    public void remover(IngredienteEscolhaDTO dto) throws SQLException {
        IngredienteEscolhaDao dao = new IngredienteEscolhaImplements();
        dao.remover(dto.builder().getId());
    }

    public List<IngredienteEscolha> listar() throws SQLException {
        IngredienteEscolhaDao dao = new IngredienteEscolhaImplements();
        return dao.listarTodos();
    }
}
