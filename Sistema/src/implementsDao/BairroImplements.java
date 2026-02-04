package implementsDao;

import bancoDados.Conexao;
import dao.BairroDao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bairro;

public class BairroImplements implements BairroDao {

    @Override
    public void salvar(Bairro bairro) {
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("INSERT INTO bairro(id, nome) VALUES (?, ?)")) {
            stmt.setInt(1, bairro.getId());
            stmt.setString(2, bairro.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Bairro bairro) {
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("UPDATE bairro SET nome = ? WHERE id = ?")) {
            stmt.setString(1, bairro.getNome());
            stmt.setInt(2, bairro.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("DELETE FROM bairro WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Bairro> listarTodos() throws SQLException {
        List<Bairro> lista = new LinkedList<>();

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM bairro");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Bairro b = new Bairro();
                b.setId(rs.getInt("id"));
                b.setNome(rs.getString("nome")); 
                lista.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
