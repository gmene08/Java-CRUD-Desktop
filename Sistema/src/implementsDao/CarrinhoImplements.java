package implementsDao;

import bancoDados.Conexao;
import dao.CarrinhoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrinho;

public class CarrinhoImplements implements CarrinhoDao{

    @Override
    public void salvar(Carrinho carrinho) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement("INSERT INTO carrinho(id, quantidade) VALUES (?, ?)");
            stmt.setInt(1, carrinho.getId());
            stmt.setInt(2, carrinho.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Carrinho carrinho) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement("UPDATE carrinho SET quantidade = ? WHERE id = ?");
            stmt.setInt(1, carrinho.getQuantidade());
            stmt.setInt(2, carrinho.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement("DELETE FROM carrinho WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Carrinho> listarTodos() throws SQLException {
        List<Carrinho> lista = new LinkedList<>();

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM carrinho");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carrinho c = new Carrinho();
                c.setId(rs.getInt("id"));
                c.setQuantidade(rs.getInt("quantidade"));
                lista.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
}
}
