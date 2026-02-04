package implementsDao;

import dao.TelefoneDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Telefone;

public class TelefoneImplements extends TelefoneDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Telefone telefone = new Telefone();

        telefone.setId(res.getInt("id"));
        telefone.setDd(res.getInt("dd"));
        telefone.setNumero(res.getString("numero"));
        
        return telefone;
    }
}
