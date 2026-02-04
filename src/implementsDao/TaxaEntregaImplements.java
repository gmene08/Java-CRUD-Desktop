package implementsDao;

import dao.TaxaEntregaDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TaxaEntrega;

public class TaxaEntregaImplements extends TaxaEntregaDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        TaxaEntrega taxaEntrega = new TaxaEntrega();

        taxaEntrega.setId(res.getInt("id"));
        taxaEntrega.setEnderecoId(res.getInt("endereco_id"));
        taxaEntrega.setTaxaEntrega(res.getDouble("taxa_entrega"));
        
        return taxaEntrega;
    }
}
