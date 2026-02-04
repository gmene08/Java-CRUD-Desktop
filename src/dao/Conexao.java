package dao;

import java.sql.*;

public class Conexao {

    private static Connection con;
    private static Conexao obj;

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";

    private Conexao() throws SQLException {
        
        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(true);
    }

    public static Conexao getInstance() throws SQLException {
        if (obj == null) {
            obj = new Conexao();
        }
        return obj;
    }

    public Connection getConexao() {
        return con;
    }

    public void fecharConexao() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    
    //Conexao.getInstance().fecharConexao();

}
