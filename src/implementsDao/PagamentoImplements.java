package implementsDao;

import dao.PagamentoDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pagamento;

public class PagamentoImplements extends PagamentoDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Pagamento pagamento = new Pagamento();

        pagamento.setId(res.getInt("id"));
        pagamento.setMetPagamentoId(res.getInt("met_pagamento_id"));
        pagamento.setCupomId(res.getInt("cupom_id"));
        pagamento.setPedidoId(res.getInt("pedido_id"));
        
        return pagamento;
    }
}
