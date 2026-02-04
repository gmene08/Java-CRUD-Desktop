package implementsDao;

import dao.BairroDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bairro;

public class BairroImplements extends BairroDao {
    
    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException{
        Bairro b = new Bairro();
        b.setNome(res.getString("nome"));
        b.setId("id");
        return b;
    }
    
}
