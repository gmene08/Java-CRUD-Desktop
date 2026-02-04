package implementsDao;

import bancoDados.Conexao;
import dao.MetPagamentoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MetPagamento;

public class MetPagamentoImplements implements MetPagamentoDao {

    @Override
    public void salvar(MetPagamento metPagamento) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO met_pagamento(id, dinheiroId, cartaoId) VALUES (?, ?, ?)"
            );
            stmt.setInt(1, metPagamento.getId());
            if (metPagamento.getDinheiroId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, metPagamento.getDinheiroId());
            }
            if (metPagamento.getCartaoId() == null) {
                stmt.setNull(3, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(3, metPagamento.getCartaoId());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetPagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(MetPagamento metPagamento) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE met_pagamento SET dinheiroId = ?, cartaoId = ? WHERE id = ?"
            );
            if (metPagamento.getDinheiroId() == null) {
                stmt.setNull(1, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(1, metPagamento.getDinheiroId());
            }
            if (metPagamento.getCartaoId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, metPagamento.getCartaoId());
            }
            stmt.setInt(3, metPagamento.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetPagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM met_pagamento WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetPagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<MetPagamento> listarTodos() {
        List<MetPagamento> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM met_pagamento");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MetPagamento m = new MetPagamento();
                m.setId(rs.getInt("id"));
                int dinheiroId = rs.getInt("dinheiroId");
                if (rs.wasNull()) {
                    m.setDinheiroId(null);
                } else {
                    m.setDinheiroId(dinheiroId);
                }
                int cartaoId = rs.getInt("cartaoId");
                if (rs.wasNull()) {
                    m.setCartaoId(null);
                } else {
                    m.setCartaoId(cartaoId);
                }
                lista.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetPagamentoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
