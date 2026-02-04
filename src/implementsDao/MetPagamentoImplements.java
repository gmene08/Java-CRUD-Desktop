package implementsDao;

import dao.MetPagamentoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MetPagamento;

public class MetPagamentoImplements extends MetPagamentoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        MetPagamento metPagamento = new MetPagamento();

        metPagamento.setId(res.getInt("id"));
        metPagamento.setDinheiroId(res.getInt("dinheiro_id"));
        metPagamento.setCartaoId(res.getInt("cartao_id"));
        
        return metPagamento;
    }
}
