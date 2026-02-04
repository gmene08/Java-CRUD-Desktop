package implementsDao;

import dao.DeliveryDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Delivery;

public class DeliveryImplements extends DeliveryDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Delivery d = new Delivery();

        d.setId(res.getInt("id"));
        d.setNumero(res.getString("numero"));
        d.setComplemento(res.getString("complemento"));
        d.setChaveEntrega(res.getInt("chave_entrega"));
        
        return d;
    }
}
