package implementsDao;

import dao.IngredienteAdicionalDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.IngredienteAdicional;

public class IngredienteAdicionalImplements extends IngredienteAdicionalDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        IngredienteAdicional ia = new IngredienteAdicional();

        ia.setId(res.getInt("id"));
        ia.setNome(res.getString("nome"));
        ia.setValor(res.getDouble("valor"));
        
        return ia;
    }
}
