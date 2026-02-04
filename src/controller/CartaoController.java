package controller;

import dao.CartaoDao;
import dto.CartaoDTO;
import implementsDao.CartaoImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Cartao;

public class CartaoController extends InterfaceController{
    
    private CartaoDao dao;
    
    public CartaoController(){
        dao = new CartaoImplements();
        dto = new CartaoDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(CartaoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(CartaoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
          return  dto.preencheLista(
                  dao.listarTodos(Cartao.class)
          );
       } catch (Exception ex) {
           System.getLogger(CartaoController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
           return null;
       }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Cartao(id));
           return true;
    }
    
}