package implementsDao;

import dao.CupomDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cupom;

public class CupomImplements extends CupomDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Cupom c = new Cupom();

        c.setId(res.getInt("id"));  
        c.setCodigo(res.getString("codigo"));  
        c.setValorCupom(res.getDouble("valor"));  
        c.setValidade(res.getString("validade"));  

        return c;  
    }
}
