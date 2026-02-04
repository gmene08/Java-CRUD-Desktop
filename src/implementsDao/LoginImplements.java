package implementsDao;

import dao.LoginDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Login;

public class LoginImplements extends LoginDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Login login = new Login();

        login.setId(res.getInt("id"));
        login.setLogin_funcionario(res.getString("login_funcionario"));
        login.setSenha(res.getString("senha"));
        
        return login;
    }
}
