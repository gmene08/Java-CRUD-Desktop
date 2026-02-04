package controller;

import dao.CupomDao;
import dto.CupomDTO;
import implementsDao.CupomImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Cupom;

public class CupomController extends InterfaceController{
    private CupomDao dao;
    
    public CupomController(){
        dao = new CupomImplements();
        dto = new CupomDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(CupomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(CupomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
          return  dto.preencheLista(
                  dao.listarTodos(Cupom.class)
          );
       } catch (Exception ex) {
           System.getLogger(CupomController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
           return null;
       }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Cupom(id));
        return true;
    }
}
