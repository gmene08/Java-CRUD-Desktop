package bancoDados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static Connection con;
    String url;
    String user;
    String password;
    private static Conexao obj; 

    private Conexao() {
        try {
            criarConexao();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao() {
        if (con == null) {
            if (obj == null) {
                obj = new Conexao(); 
            }
        }
        return con;
    }

    public Connection criarConexao() throws SQLException {
        url = "jdbc:postgresql://localhost:5432/projeto_prova2";
        user = "postgres";
        password = "123";
        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(true);
        return con;
    }
}
