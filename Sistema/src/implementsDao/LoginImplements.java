package implementsDao;

import bancoDados.Conexao;
import dao.LoginDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

public class LoginImplements implements LoginDao {

    @Override
    public void salvar(Login login) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO login(id, senha, login_funcionario) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, login.getId());
            stmt.setString(2, login.getSenha());
            stmt.setString(3, login.getLogin_funcionario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Login login) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE login SET senha = ?, login_funcionario = ? WHERE id = ?"
            );
            stmt.setString(1, login.getSenha());
            stmt.setString(2, login.getLogin_funcionario());
            stmt.setInt(3, login.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM login WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Login> listarTodos() {
        List<Login> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM login");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Login l = new Login();
                l.setId(rs.getInt("id"));
                l.setSenha(rs.getString("senha"));
                l.setLogin_funcionario(rs.getString("login_funcionario"));
                lista.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
