package implementsDao;

import bancoDados.Conexao;
import dao.IngredienteRemoverDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IngredienteRemover;

public class IngredienteRemoverImplements implements IngredienteRemoverDao {

    @Override
    public void salvar(IngredienteRemover ingredienteRemover) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO ingrediente_remover(id, nome) VALUES (?, ?)"
            );
            stmt.setInt(1, ingredienteRemover.getId());
            stmt.setString(2, ingredienteRemover.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(IngredienteRemover ingredienteRemover) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE ingrediente_remover SET nome = ? WHERE id = ?"
            );
            stmt.setString(1, ingredienteRemover.getNome());
            stmt.setInt(2, ingredienteRemover.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM ingrediente_remover WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IngredienteRemover> listarTodos() {
        List<IngredienteRemover> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM ingrediente_remover");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                IngredienteRemover i = new IngredienteRemover();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteRemoverImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
