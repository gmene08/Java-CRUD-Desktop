package implementsDao;

import bancoDados.Conexao;
import dao.PedidoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;

public class PedidoImplements implements PedidoDao {

    @Override
    public void salvar(Pedido pedido) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO pedido(id, horaPedido, clienteId, numeroPedido, carrinhoId, dataPedido, statusPedidoId, entregaId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setInt(1, pedido.getId());
            stmt.setString(2, pedido.getHoraPedido());
            stmt.setInt(3, pedido.getClienteId());
            stmt.setString(4, pedido.getNumeroPedido());
            stmt.setInt(5, pedido.getCarrinhoId());
            stmt.setString(6, pedido.getDataPedido());
            stmt.setInt(7, pedido.getStatusPedidoId());
            stmt.setInt(8, pedido.getEntregaId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Pedido pedido) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE pedido SET horaPedido = ?, clienteId = ?, numeroPedido = ?, carrinhoId = ?, dataPedido = ?, statusPedidoId = ?, entregaId = ? WHERE id = ?"
            );
            stmt.setString(1, pedido.getHoraPedido());
            stmt.setInt(2, pedido.getClienteId());
            stmt.setString(3, pedido.getNumeroPedido());
            stmt.setInt(4, pedido.getCarrinhoId());
            stmt.setString(5, pedido.getDataPedido());
            stmt.setInt(6, pedido.getStatusPedidoId());
            stmt.setInt(7, pedido.getEntregaId());
            stmt.setInt(8, pedido.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM pedido WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pedido> listarTodos() {
        List<Pedido> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM pedido");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setHoraPedido(rs.getString("horaPedido"));
                p.setClienteId(rs.getInt("clienteId"));
                p.setNumeroPedido(rs.getString("numeroPedido"));
                p.setCarrinhoId(rs.getInt("carrinhoId"));
                p.setDataPedido(rs.getString("dataPedido"));
                p.setStatusPedidoId(rs.getInt("statusPedidoId"));
                p.setEntregaId(rs.getInt("entregaId"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
