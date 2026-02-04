package implementsDao;

import dao.ProdutoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;

public class ProdutoImplements extends ProdutoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Produto produto = new Produto();

        produto.setId(res.getInt("id"));
        produto.setNome(res.getString("nome"));
        produto.setValorUnitario(res.getDouble("valor_unitario"));
        
        return produto;
    }
}
