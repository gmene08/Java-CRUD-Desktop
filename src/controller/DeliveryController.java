package controller;

import dao.DeliveryDao;
import dto.DeliveryDTO;
import implementsDao.DeliveryImplements;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import java.util.List;
import model.Delivery;

public class DeliveryController extends InterfaceController {

    private DeliveryDao dao;
    
    public DeliveryController() {
        dao = new DeliveryImplements();
        dto = new DeliveryDTO();
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            return dto.preencheLista(
                    dao.listarTodos(Delivery.class)
            );
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) throws Exception {
        dao.remover(new Delivery(id));
        return true;
    }
}
