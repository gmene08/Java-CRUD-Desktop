package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class LoginDao extends InterfaceDAO{
    @Override
    public abstract Entidade preencheDados(ResultSet res) throws SQLException;
}
