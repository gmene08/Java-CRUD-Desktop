package implementsDao;

import bancoDados.Conexao;
import dao.DinheiroDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dinheiro;

public class DinheiroImplements implements DinheiroDao {

    @Override
    public void salvar(Dinheiro dinheiro) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO dinheiro(id, valorEntregue, metPagamento_id) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, dinheiro.getId());
            stmt.setDouble(2, dinheiro.getValorEntregue());
            stmt.setInt(3, dinheiro.getMetPagamento() == null ? 0 : dinheiro.getMetPagamento().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DinheiroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Dinheiro dinheiro) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE dinheiro SET valorEntregue = ?, metPagamento_id = ? WHERE id = ?"
            );
            stmt.setDouble(1, dinheiro.getValorEntregue());
            stmt.setInt(2, dinheiro.getMetPagamento() == null ? 0 : dinheiro.getMetPagamento().getId());
            stmt.setInt(3, dinheiro.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DinheiroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM dinheiro WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DinheiroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Dinheiro> listarTodos() {
        List<Dinheiro> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM dinheiro");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dinheiro d = new Dinheiro();
                d.setId(rs.getInt("id"));
                d.setValorEntregue(rs.getDouble("valorEntregue"));
                
                model.MetPagamento met = new model.MetPagamento();
                met.setId(rs.getInt("metPagamento_id"));
                d.setMetPagamento(met);

                lista.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DinheiroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
