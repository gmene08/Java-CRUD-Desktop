package implementsDao;

import bancoDados.Conexao;
import dao.StatusPedidoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StatusPedido;

public class StatusPedidoImplements implements StatusPedidoDao {

    @Override
    public void salvar(StatusPedido statusPedido) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO statusPedido(id, pedidoId, progresso) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, statusPedido.getId());
            stmt.setInt(2, statusPedido.getPedidoId());
            stmt.setString(3, statusPedido.getProgresso());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(StatusPedido statusPedido) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE statusPedido SET pedidoId = ?, progresso = ? WHERE id = ?"
            );
            stmt.setInt(1, statusPedido.getPedidoId());
            stmt.setString(2, statusPedido.getProgresso());
            stmt.setInt(3, statusPedido.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM statusPedido WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<StatusPedido> listarTodos() {
        List<StatusPedido> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM statusPedido");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                StatusPedido sp = new StatusPedido();
                sp.setId(rs.getInt("id"));
                sp.setPedidoId(rs.getInt("pedidoId"));
                sp.setProgresso(rs.getString("progresso"));
                lista.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusPedidoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
