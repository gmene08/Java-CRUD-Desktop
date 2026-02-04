package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente extends Entidade {
    private String nome;
    private Telefone telefone;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getInsert() {
        return "cliente (nome, telefone_id) values(?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, nome);  
        if (telefone != null && telefone.getId() != null) {
            prepareStatement.setInt(2, telefone.getId()); 
        } else {
            prepareStatement.setNull(2, java.sql.Types.INTEGER);  
        }
        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId());  
        }
}

    @Override
    public String getupdate() {
        return "cliente set nome=?, telefone_id=? where id=?";
    }
}
