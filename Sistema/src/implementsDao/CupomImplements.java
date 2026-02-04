package implementsDao;

import bancoDados.Conexao;
import dao.CupomDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cupom;

public class CupomImplements implements CupomDao {

    @Override
    public void salvar(Cupom cupom) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO cupom(id, valorCupom, codigo, validade) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, cupom.getId());
            stmt.setDouble(2, cupom.getValorCupom());
            stmt.setString(3, cupom.getCodigo());
            stmt.setString(4, cupom.getValidade());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CupomImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Cupom cupom) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE cupom SET valorCupom = ?, codigo = ?, validade = ? WHERE id = ?"
            );
            stmt.setDouble(1, cupom.getValorCupom());
            stmt.setString(2, cupom.getCodigo());
            stmt.setString(3, cupom.getValidade());
            stmt.setInt(4, cupom.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CupomImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM cupom WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CupomImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cupom> listarTodos() {
        List<Cupom> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM cupom");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cupom c = new Cupom();
                c.setId(rs.getInt("id"));
                c.setValorCupom(rs.getDouble("valorCupom"));
                c.setCodigo(rs.getString("codigo"));
                c.setValidade(rs.getString("validade"));
                lista.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CupomImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
