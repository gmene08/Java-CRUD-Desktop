package controller;

import dao.BairroDao;
import dto.BairroDTO;
import implementsDao.BairroImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Bairro;

public class BairroController extends InterfaceController{
    private BairroDao dao;
    
    public BairroController(){
        dao = new BairroImplements();
        dto = new BairroDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(BairroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(BairroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
          return  dto.preencheLista(
                  dao.listarTodos(Bairro.class)
          );
       } catch (Exception ex) {
           System.getLogger(BairroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
           return null;
       }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
            dao.remover(new Bairro(id));
           return true;
    }

    
}
