package implementsDao;

import dao.ReembolsoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Reembolso;

public class ReembolsoImplements extends ReembolsoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Reembolso reembolso = new Reembolso();

        reembolso.setId(res.getInt("id"));
        reembolso.setPedidoId(res.getInt("pedido_id"));
        reembolso.setMotivo(res.getString("motivo"));
        
        return reembolso;
    }
}
