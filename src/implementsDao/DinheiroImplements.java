package implementsDao;

import dao.DinheiroDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Dinheiro;

public class DinheiroImplements extends DinheiroDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Dinheiro d = new Dinheiro();

        d.setId(res.getInt("id"));
        d.setValorEntregue(res.getDouble("valor_entregue"));

        return d;
    }
}
