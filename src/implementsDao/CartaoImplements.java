package implementsDao;

import dao.CartaoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cartao;

public class CartaoImplements extends CartaoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Cartao c = new Cartao();

        c.setNumCartao(res.getString("numCartao"));  
        c.setCvv(res.getString("cvv"));  
        c.setTipo(res.getInt("tipo"));  

        return c;  
    }
}
