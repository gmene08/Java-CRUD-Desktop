package implementsDao;

import bancoDados.Conexao;
import dao.DeliveryDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Delivery;

public class DeliveryImplements implements DeliveryDao {

    @Override
    public void salvar(Delivery delivery) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO delivery(id, chaveEntrega, numero, complemento) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, delivery.getId());
            stmt.setInt(2, delivery.getChaveEntrega());
            stmt.setString(3, delivery.getNumero());
            stmt.setString(4, delivery.getComplemento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Delivery delivery) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE delivery SET chaveEntrega = ?, numero = ?, complemento = ? WHERE id = ?"
            );
            stmt.setInt(1, delivery.getChaveEntrega());
            stmt.setString(2, delivery.getNumero());
            stmt.setString(3, delivery.getComplemento());
            stmt.setInt(4, delivery.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM delivery WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Delivery> listarTodos() {
        List<Delivery> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM delivery");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Delivery d = new Delivery();
                d.setId(rs.getInt("id"));
                d.setChaveEntrega(rs.getInt("chaveEntrega"));
                d.setNumero(rs.getString("numero"));
                d.setComplemento(rs.getString("complemento"));
                lista.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DeliveryImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
