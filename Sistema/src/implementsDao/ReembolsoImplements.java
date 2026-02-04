package implementsDao;

import bancoDados.Conexao;
import dao.ReembolsoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reembolso;

public class ReembolsoImplements implements ReembolsoDao {

    @Override
    public void salvar(Reembolso reembolso) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO reembolso(id, pedidoId, motivo) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, reembolso.getId());
            stmt.setInt(2, reembolso.getPedidoId());
            stmt.setString(3, reembolso.getMotivo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Reembolso reembolso) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE reembolso SET pedidoId = ?, motivo = ? WHERE id = ?"
            );
            stmt.setInt(1, reembolso.getPedidoId());
            stmt.setString(2, reembolso.getMotivo());
            stmt.setInt(3, reembolso.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM reembolso WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reembolso> listarTodos() {
        List<Reembolso> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM reembolso");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Reembolso r = new Reembolso();
                r.setId(rs.getInt("id"));
                r.setPedidoId(rs.getInt("pedidoId"));
                r.setMotivo(rs.getString("motivo"));
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReembolsoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
