package implementsDao;

import bancoDados.Conexao;
import dao.CartaoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cartao;

public class CartaoImplements implements CartaoDao{

    @Override
    public void salvar(Cartao cartao) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement("INSERT INTO cartao(id, numCartao, cvv, tipo) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, cartao.getId());
            stmt.setString(2, cartao.getNumCartao());
            stmt.setString(3, cartao.getCvv());
            stmt.setInt(4, cartao.getTipo());
        } catch (SQLException ex) {
            Logger.getLogger(CartaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    @Override
    public void editar(Cartao cartao) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement("UPDATE cartao SET numCartao = ?, cvv = ?, tipo = ? WHERE id = ?");
            stmt.setString(1, cartao.getNumCartao());
            stmt.setString(2, cartao.getCvv());
            stmt.setInt(3, cartao.getTipo());
            stmt.setInt(4, cartao.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CartaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement("DELETE FROM cartao WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Override
    public List<Cartao> listarTodos() {
        List<Cartao> lista = new LinkedList<>();

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM cartao");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cartao c = new Cartao();
                c.setId(rs.getInt("id"));
                c.setNumCartao(rs.getString("numCartao"));
                c.setCvv(rs.getString("cvv"));
                c.setTipo(rs.getInt("tipo"));
                lista.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
}
