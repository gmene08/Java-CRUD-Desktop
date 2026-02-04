package implementsDao;

import dao.StatusPedidoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.StatusPedido;

public class StatusPedidoImplements extends StatusPedidoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        StatusPedido statusPedido = new StatusPedido();

        statusPedido.setId(res.getInt("id"));
        statusPedido.setPedidoId(res.getInt("pedido_id"));
        statusPedido.setProgresso(res.getString("progresso"));

        return statusPedido;
    }
}
