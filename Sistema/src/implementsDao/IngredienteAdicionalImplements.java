package implementsDao;

import bancoDados.Conexao;
import dao.IngredienteAdicionalDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IngredienteAdicional;

public class IngredienteAdicionalImplements implements IngredienteAdicionalDao {

    @Override
    public void salvar(IngredienteAdicional ingrediente) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO ingrediente_adicional(id, nome, valor) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, ingrediente.getId());
            stmt.setString(2, ingrediente.getNome());
            stmt.setDouble(3, ingrediente.getValor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionalImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(IngredienteAdicional ingrediente) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE ingrediente_adicional SET nome = ?, valor = ? WHERE id = ?"
            );
            stmt.setString(1, ingrediente.getNome());
            stmt.setDouble(2, ingrediente.getValor());
            stmt.setInt(3, ingrediente.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionalImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM ingrediente_adicional WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionalImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IngredienteAdicional> listarTodos() {
        List<IngredienteAdicional> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM ingrediente_adicional");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                IngredienteAdicional i = new IngredienteAdicional();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setValor(rs.getDouble("valor"));
                lista.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteAdicionalImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
