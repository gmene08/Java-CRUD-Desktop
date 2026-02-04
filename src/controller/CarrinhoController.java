package controller;

import dao.CarrinhoDao;
import dto.CarrinhoDTO;
import implementsDao.CarrinhoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Carrinho;

public class CarrinhoController extends InterfaceController{
    private CarrinhoDao dao;

    public CarrinhoController() {
        dao = new CarrinhoImplements();
        dto = new CarrinhoDTO();
    }
    
    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(CarrinhoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(CarrinhoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
          return  dto.preencheLista(
                  dao.listarTodos(Carrinho.class)
          );
       } catch (Exception ex) {
           System.getLogger(CarrinhoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
           return null;
       }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Carrinho(id));
        return true;
    }
}
