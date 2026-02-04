package implementsDao;

import dao.FuncionarioDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;

public class FuncionarioImplements extends FuncionarioDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Funcionario f = new Funcionario();

        f.setId(res.getInt("id"));
        f.setNome(res.getString("nome"));
        f.setCpf(res.getString("cpf"));
        f.setRg(res.getString("rg"));
        
        return f;
    }
}
