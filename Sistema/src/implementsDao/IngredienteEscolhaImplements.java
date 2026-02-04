package implementsDao;

import bancoDados.Conexao;
import dao.IngredienteEscolhaDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IngredienteEscolha;

public class IngredienteEscolhaImplements implements IngredienteEscolhaDao {

    @Override
    public void salvar(IngredienteEscolha ingredienteEscolha) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO ingrediente_escolha(id, ingredienteEscolhaId, ingredienteRemoverId) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, ingredienteEscolha.getId());
            if (ingredienteEscolha.getIngredienteEscolhaId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, ingredienteEscolha.getIngredienteEscolhaId());
            }
            if (ingredienteEscolha.getIngredienteRemoverId() == null) {
                stmt.setNull(3, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(3, ingredienteEscolha.getIngredienteRemoverId());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(IngredienteEscolha ingredienteEscolha) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE ingrediente_escolha SET ingredienteEscolhaId = ?, ingredienteRemoverId = ? WHERE id = ?"
            );
            if (ingredienteEscolha.getIngredienteEscolhaId() == null) {
                stmt.setNull(1, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(1, ingredienteEscolha.getIngredienteEscolhaId());
            }
            if (ingredienteEscolha.getIngredienteRemoverId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, ingredienteEscolha.getIngredienteRemoverId());
            }
            stmt.setInt(3, ingredienteEscolha.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM ingrediente_escolha WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IngredienteEscolha> listarTodos() {
        List<IngredienteEscolha> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM ingrediente_escolha");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                IngredienteEscolha i = new IngredienteEscolha();
                i.setId(rs.getInt("id"));
                int escolhaId = rs.getInt("ingredienteEscolhaId");
                if (rs.wasNull()) {
                    i.setIngredienteEscolhaId(null);
                } else {
                    i.setIngredienteEscolhaId(escolhaId);
                }
                int removerId = rs.getInt("ingredienteRemoverId");
                if (rs.wasNull()) {
                    i.setIngredienteRemoverId(null);
                } else {
                    i.setIngredienteRemoverId(removerId);
                }
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteEscolhaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
