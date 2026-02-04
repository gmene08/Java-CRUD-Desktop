package implementsDao;

import dao.EntregaDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Entrega;

public class EntregaImplements extends EntregaDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Entrega e = new Entrega();

        e.setId(res.getInt("id"));
        e.setTipoEntrega(res.getString("tipo_entrega"));
        e.setStatusPedidoId(res.getInt("status_pedido_id"));

        return e;
    }
}
