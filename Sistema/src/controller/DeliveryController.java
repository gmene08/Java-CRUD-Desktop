package controller;

import dao.DeliveryDao;
import dto.DeliveryDTO;
import implementsDao.DeliveryImplements;
import java.sql.SQLException;
import java.util.List;
import model.Delivery;

public class DeliveryController {

    public void salvar(DeliveryDTO deliveryDTO) throws SQLException {
        DeliveryDao dao = new DeliveryImplements();
        dao.salvar(deliveryDTO.builder());
    }

    public void editar(DeliveryDTO deliveryDTO) throws SQLException {
        DeliveryDao dao = new DeliveryImplements();
        dao.editar(deliveryDTO.builder());
    }

    public void remover(DeliveryDTO deliveryDTO) throws SQLException {
        DeliveryDao dao = new DeliveryImplements();
        dao.remover(deliveryDTO.builder().getId());
    }

    public List<Delivery> listar() throws SQLException {
        DeliveryDao dao = new DeliveryImplements();
        return dao.listarTodos();
    }
}
