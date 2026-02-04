package implementsDao;

import bancoDados.Conexao;
import dao.EnderecoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bairro;
import model.Delivery;
import model.Endereco;

public class EnderecoImplements implements EnderecoDao {

    @Override
    public void salvar(Endereco endereco) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "INSERT INTO endereco(id, rua, cep, distancia, delivery_id, bairro_id) VALUES (?, ?, ?, ?, ?, ?)"
            );
            stmt.setInt(1, endereco.getId());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getCep());
            stmt.setDouble(4, endereco.getDistancia());
            stmt.setInt(5, endereco.getDelivery() == null ? 0 : endereco.getDelivery().getId());
            stmt.setInt(6, endereco.getBairro() == null ? 0 : endereco.getBairro().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Endereco endereco) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "UPDATE endereco SET rua = ?, cep = ?, distancia = ?, delivery_id = ?, bairro_id = ? WHERE id = ?"
            );
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getCep());
            stmt.setDouble(3, endereco.getDistancia());
            stmt.setInt(4, endereco.getDelivery() == null ? 0 : endereco.getDelivery().getId());
            stmt.setInt(5, endereco.getBairro() == null ? 0 : endereco.getBairro().getId());
            stmt.setInt(6, endereco.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(
                "DELETE FROM endereco WHERE id = ?"
            );
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Endereco> listarTodos() {
        List<Endereco> lista = new LinkedList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement("SELECT * FROM endereco");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Endereco e = new Endereco();
                e.setId(rs.getInt("id"));
                e.setRua(rs.getString("rua"));
                e.setCep(rs.getString("cep"));
                e.setDistancia(rs.getDouble("distancia"));

                Delivery delivery = new Delivery();
                delivery.setId(rs.getInt("delivery_id"));
                e.setDelivery(delivery);

                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("bairro_id"));
                e.setBairro(bairro);

                lista.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
