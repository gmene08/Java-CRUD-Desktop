package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login extends Entidade{
    private String senha;
    private String login_funcionario;
    
    private Funcionario funcionarios;

    public Login(Integer id) {
        setId(id);
    }

    public Login() {
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin_funcionario() {
        return login_funcionario;
    }

    public void setLogin_funcionario(String login_funcionario) {
        this.login_funcionario = login_funcionario;
    }

    public Funcionario getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO login (login_funcionario, senha, funcionario_id) VALUES (?, ?, ?)";
    
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, login_funcionario);  
        prepareStatement.setString(2, senha);              

        if (funcionarios != null) {
            prepareStatement.setInt(3, funcionarios.getId());  
        } else {
            prepareStatement.setNull(3, java.sql.Types.INTEGER); 
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(4, getId());  
        }
    }

    @Override
    public String getupdate() {
         return "UPDATE login SET login_funcionario=?, senha=?, funcionario_id=? WHERE id=?";
    }
}
