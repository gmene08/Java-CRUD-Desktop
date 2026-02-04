package implementsDao;

import dao.IngredienteEscolhaDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.IngredienteEscolha;

public class IngredienteEscolhaImplements extends IngredienteEscolhaDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        IngredienteEscolha ie = new IngredienteEscolha();

        ie.setId(res.getInt("id"));
        ie.setIngredienteEscolhaId(res.getInt("ingrediente_escolha_id"));
        ie.setIngredienteRemoverId(res.getInt("ingrediente_remover_id"));
        
        return ie;
    }
}
