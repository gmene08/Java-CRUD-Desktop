package implementsDao;

import bancoDados.Conexao;
import dao.TelefoneDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Telefone;

public class TelefoneImplements implements TelefoneDao {

    @Override
    public void salvar(Telefone telefone) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO telefone(id, dd, numero) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, telefone.getId());
            stmt.setInt(2, telefone.getDd());
            stmt.setInt(3, telefone.getNumero());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Telefone telefone) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE telefone SET dd = ?, numero = ? WHERE id = ?"
            );
            stmt.setInt(1, telefone.getDd());
            stmt.setInt(2, telefone.getNumero());
            stmt.setInt(3, telefone.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM telefone WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Telefone> listarTodos() {
        List<Telefone> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM telefone");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Telefone t = new Telefone();
                t.setId(rs.getInt("id"));
                t.setDd(rs.getInt("dd"));
                t.setNumero(rs.getInt("numero"));
                lista.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
