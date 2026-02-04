package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Funcionario extends Entidade{
    private String nome;
    private String cpf;
    private String rg;
    
    private List<Login> logins;
    private Telefone telefones;

    public Funcionario(Integer id) {
        setId(id);
    }

    public Funcionario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    public Telefone getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone telefones) {
        this.telefones = telefones;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO funcionario (nome, cpf, rg, telefone_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, nome); 
        prepareStatement.setString(2, cpf);   
        prepareStatement.setString(3, rg);    
        
        if (telefones != null) {
            prepareStatement.setInt(4, telefones.getId());  
        } else {
            prepareStatement.setNull(4, java.sql.Types.INTEGER);  
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(5, getId());  
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE funcionario SET nome=?, cpf=?, rg=?, telefone_id=? WHERE id=?";
    }
    
}
