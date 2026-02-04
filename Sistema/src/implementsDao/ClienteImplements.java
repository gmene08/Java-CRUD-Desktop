package implementsDao;

import bancoDados.Conexao;
import dao.ClienteDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

public class ClienteImplements implements ClienteDao {

    @Override
    public void salvar(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao()
                    .prepareStatement("INSERT INTO cliente(id, nome) VALUES (?, ?)");
            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao()
                    .prepareStatement("UPDATE cliente SET nome = ? WHERE id = ?");
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getId());
            preparedStatement.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao()
                    .prepareStatement("DELETE FROM cliente WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> itens = new LinkedList<>();

        PreparedStatement preparedStatement = Conexao.getConexao()
                .prepareStatement("SELECT * FROM cliente");

        ResultSet resultSet = preparedStatement.executeQuery(); 

        while (resultSet.next()) {
            Cliente c = new Cliente();
            c.setId(resultSet.getInt("id"));
            c.setNome(resultSet.getString("nome"));  
            itens.add(c);
        }
        return itens;
    }
}
