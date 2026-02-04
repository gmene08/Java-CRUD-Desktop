package implementsDao;

import dao.CarrinhoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Carrinho;

public class CarrinhoImplements extends CarrinhoDao{

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Carrinho c = new Carrinho();
        c.setQuantidade(res.getInt("quantidade"));
        c.setId("id");
        return c;
    }
    
}
