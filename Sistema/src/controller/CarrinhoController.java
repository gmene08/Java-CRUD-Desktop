package controller;

import dao.CarrinhoDao;
import dto.CarrinhoDTO;
import implementsDao.CarrinhoImplements;
import java.sql.SQLException;

public class CarrinhoController {
    
    public void salvar(CarrinhoDTO carrinhoDTO) throws SQLException{
        CarrinhoDao dao = new CarrinhoImplements();
        dao.salvar(carrinhoDTO.builder());
    }
    
    public void editar(CarrinhoDTO carrinhoDTO) throws SQLException{
        CarrinhoDao dao = new CarrinhoImplements();
        dao.editar(carrinhoDTO.builder());
    }
    
    public void remover(CarrinhoDTO carrinhoDTO) throws SQLException{
        CarrinhoDao dao = new CarrinhoImplements();
        dao.remover(carrinhoDTO.builder().getId());
    }
    
    public void listar(CarrinhoDTO carrinhoDTO) throws SQLException{
        CarrinhoDao dao = new CarrinhoImplements();
        dao.listarTodos();
    }
}
