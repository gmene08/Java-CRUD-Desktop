package implementsDao;

import dao.PedidoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pedido;

public class PedidoImplements extends PedidoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Pedido pedido = new Pedido();

        pedido.setId(res.getInt("id"));
        pedido.setHoraPedido(res.getString("hora_pedido"));
        pedido.setClienteId(res.getInt("cliente_id"));
        pedido.setNumeroPedido(res.getString("numero_pedido"));
        pedido.setCarrinhoId(res.getInt("carrinho_id"));
        pedido.setDataPedido(res.getString("data_pedido"));
        pedido.setStatusPedidoId(res.getInt("status_pedido_id"));
        pedido.setEntregaId(res.getInt("entrega_id"));

        return pedido;
    }
}
