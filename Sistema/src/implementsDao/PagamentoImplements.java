package implementsDao;

import bancoDados.Conexao;
import dao.PagamentoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pagamento;

public class PagamentoImplements implements PagamentoDao {

    @Override
    public void salvar(Pagamento pagamento) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO pagamento(id, metPagamentoId, cupomId, pedidoId) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, pagamento.getId());
            stmt.setInt(2, pagamento.getMetPagamentoId());
            stmt.setInt(3, pagamento.getCupomId());
            stmt.setInt(4, pagamento.getPedidoId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Pagamento pagamento) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE pagamento SET metPagamentoId = ?, cupomId = ?, pedidoId = ? WHERE id = ?"
            );
            stmt.setInt(1, pagamento.getMetPagamentoId());
            stmt.setInt(2, pagamento.getCupomId());
            stmt.setInt(3, pagamento.getPedidoId());
            stmt.setInt(4, pagamento.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM pagamento WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pagamento> listarTodos() {
        List<Pagamento> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM pagamento");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamento p = new Pagamento();
                p.setId(rs.getInt("id"));
                p.setMetPagamentoId(rs.getInt("metPagamentoId"));
                p.setCupomId(rs.getInt("cupomId"));
                p.setPedidoId(rs.getInt("pedidoId"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
