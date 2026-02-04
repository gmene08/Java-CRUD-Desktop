package implementsDao;

import dao.IngredienteRemoverDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.IngredienteRemover;

public class IngredienteRemoverImplements extends IngredienteRemoverDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        IngredienteRemover ir = new IngredienteRemover();

        ir.setId(res.getInt("id"));
        ir.setNome(res.getString("nome"));
        
        return ir;
    }
}
