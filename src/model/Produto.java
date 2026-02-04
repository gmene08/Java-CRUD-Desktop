package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Produto extends Entidade{
    private String nome;
    private double valorUnitario;
    
    private Carrinho carrinho;

    public Produto(Integer id) {
        setId(id);
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO produto (nome, valor_unitario, carrinho_id) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setString(1, nome);
        prepareStatement.setDouble(2, valorUnitario);

        if (carrinho != null) {
            prepareStatement.setInt(3, carrinho.getId());  // Atribuindo o ID do Carrinho
        } else {
            prepareStatement.setNull(3, java.sql.Types.INTEGER);  // Se o carrinho for nulo, insere NULL
        }

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(4, getId());  // Definindo o ID do Produto, caso exista
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE produto SET nome=?, valor_unitario=?, carrinho_id=? WHERE id=?";
    }

}
