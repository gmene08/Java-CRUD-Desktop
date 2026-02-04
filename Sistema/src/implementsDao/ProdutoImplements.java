package implementsDao;

import bancoDados.Conexao;
import dao.ProdutoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

public class ProdutoImplements implements ProdutoDao {

    @Override
    public void salvar(Produto produto) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO produto(id, nome, valorUnitario) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getValorUnitario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Produto produto) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE produto SET nome = ?, valorUnitario = ? WHERE id = ?"
            );
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValorUnitario());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM produto WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM produto");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValorUnitario(rs.getDouble("valorUnitario"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
