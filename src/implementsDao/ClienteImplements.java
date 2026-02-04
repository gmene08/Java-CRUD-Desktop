package implementsDao;

import dao.ClienteDao;
import interfaces.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import model.Telefone;

public class ClienteImplements extends ClienteDao {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(res.getInt("id"));
        cliente.setNome(res.getString("nome"));

        String telefoneNumero = res.getString("telefone_numero");
        if (telefoneNumero != null) {
            Telefone telefone = new Telefone();
            telefone.setNumero(telefoneNumero); 
            cliente.setTelefone(telefone); 
        }

        return cliente;
    }
}
