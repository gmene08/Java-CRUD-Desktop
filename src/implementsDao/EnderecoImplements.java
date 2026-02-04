package implementsDao;

import dao.EnderecoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;

public class EnderecoImplements extends EnderecoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Endereco e = new Endereco();

        e.setId(res.getInt("id"));
        e.setRua(res.getString("rua"));
        e.setCep(res.getString("cep"));
        e.setDistancia(res.getDouble("distancia"));

        return e;
    }
}
