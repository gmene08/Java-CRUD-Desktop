package interfaces;

import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class InterfaceDAO {

    public void salvar(Entidade e) throws Exception {
    String sql = "insert into " + e.getInsert();
    PreparedStatement prepareStatement
            = Conexao.getInstance().getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    e.setParameter(prepareStatement);
    prepareStatement.executeUpdate();

    ResultSet rs = prepareStatement.getGeneratedKeys();
    if (rs.next()) {
        int generatedId = rs.getInt(1); 
        e.setId(generatedId); 
    }
}

    public void editar(Entidade e) throws Exception {
        String sql="update " + e.getupdate() + " where id =?";
        PreparedStatement prepareStatement
                = Conexao.getInstance().getConexao().
                        prepareStatement(sql);
        e.setParameter(prepareStatement);
        prepareStatement.executeUpdate();

    }
    public void remover(Entidade e) throws Exception {
        String sql="delete from "+ e.getClass().getSimpleName() + " where id =?";
        PreparedStatement prepareStatement = Conexao.getInstance().getConexao().
                prepareStatement(sql);
                prepareStatement.setInt(1, e.getId());
                prepareStatement.executeUpdate();

    }
    
    public List listarTodos(Class c) throws Exception {
        List lista = new LinkedList();

        String query = "SELECT * FROM " + c.getSimpleName();

        ResultSet res = Conexao.getInstance().getConexao()
                .createStatement()
                .executeQuery(query);

        while (res.next()) {
            lista.add(preencheDados(res));  
        }
        return lista;
    }

    public abstract Entidade preencheDados(ResultSet res) throws SQLException;
    
}
