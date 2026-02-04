package implementsDao;

import bancoDados.Conexao;
import dao.EntregaDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entrega;

public class EntregaImplements implements EntregaDao {

    @Override
    public void salvar(Entrega entrega) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO entrega(id, tipoEntrega, statusPedidoId) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, entrega.getId());
            stmt.setString(2, entrega.getTipoEntrega());
            stmt.setInt(3, entrega.getStatusPedidoId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Entrega entrega) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE entrega SET tipoEntrega = ?, statusPedidoId = ? WHERE id = ?"
            );
            stmt.setString(1, entrega.getTipoEntrega());
            stmt.setInt(2, entrega.getStatusPedidoId());
            stmt.setInt(3, entrega.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM entrega WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Entrega> listarTodos() {
        List<Entrega> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM entrega");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Entrega e = new Entrega();
                e.setId(rs.getInt("id"));
                e.setTipoEntrega(rs.getString("tipoEntrega"));
                e.setStatusPedidoId(rs.getInt("statusPedidoId"));
                lista.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
