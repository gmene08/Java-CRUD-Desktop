package implementsDao;

import bancoDados.Conexao;
import dao.TaxaEntregaDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaxaEntrega;

public class TaxaEntregaImplements implements TaxaEntregaDao {

    @Override
    public void salvar(TaxaEntrega taxaEntrega) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO taxaEntrega(id, enderecoId, taxaEntrega) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, taxaEntrega.getId());
            stmt.setInt(2, taxaEntrega.getEnderecoId());
            stmt.setDouble(3, taxaEntrega.getTaxaEntrega());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(TaxaEntrega taxaEntrega) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE taxaEntrega SET enderecoId = ?, taxaEntrega = ? WHERE id = ?"
            );
            stmt.setInt(1, taxaEntrega.getEnderecoId());
            stmt.setDouble(2, taxaEntrega.getTaxaEntrega());
            stmt.setInt(3, taxaEntrega.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM taxaEntrega WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TaxaEntrega> listarTodos() {
        List<TaxaEntrega> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM taxaEntrega");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TaxaEntrega te = new TaxaEntrega();
                te.setId(rs.getInt("id"));
                te.setEnderecoId(rs.getInt("enderecoId"));
                te.setTaxaEntrega(rs.getDouble("taxaEntrega"));
                lista.add(te);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaxaEntregaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
