package controller;

import dao.IngredienteAdicionalDao;
import dto.IngredienteAdicionalDTO;
import implementsDao.IngredienteAdicionalImplements;
import java.sql.SQLException;
import java.util.List;
import model.IngredienteAdicional;

public class IngredienteAdicionalController {

    public void salvar(IngredienteAdicionalDTO ingredienteDTO) throws SQLException {
        IngredienteAdicionalDao dao = new IngredienteAdicionalImplements();
        dao.salvar(ingredienteDTO.builder());
    }

    public void editar(IngredienteAdicionalDTO ingredienteDTO) throws SQLException {
        IngredienteAdicionalDao dao = new IngredienteAdicionalImplements();
        dao.editar(ingredienteDTO.builder());
    }

    public void remover(IngredienteAdicionalDTO ingredienteDTO) throws SQLException {
        IngredienteAdicionalDao dao = new IngredienteAdicionalImplements();
        dao.remover(ingredienteDTO.builder().getId());
    }

    public List<IngredienteAdicional> listar() throws SQLException {
        IngredienteAdicionalDao dao = new IngredienteAdicionalImplements();
        return dao.listarTodos();
    }
}
