package implementsDao;

import bancoDados.Conexao;
import dao.FuncionarioDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;

public class FuncionarioImplements implements FuncionarioDao {

    @Override
    public void salvar(Funcionario funcionario) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO funcionario(id, nome, cpf, rg) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getRg());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Funcionario funcionario) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE funcionario SET nome = ?, cpf = ?, rg = ? WHERE id = ?"
            );
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM funcionario WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM funcionario");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
