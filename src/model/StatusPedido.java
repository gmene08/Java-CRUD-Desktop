package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusPedido extends Entidade{
    private int pedidoId;
    private String progresso;
    
    private Pedido pedido;

    public StatusPedido(Integer id) {
        setId(id);
    }

    public StatusPedido() {
    }
    
    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO status_pedido (pedido_id, progresso) VALUES (?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.setInt(1, pedidoId);  
        prepareStatement.setString(2, progresso);  

        if (getId() != null && getId() > 0) {
            prepareStatement.setInt(3, getId());  
        }
    }

    @Override
    public String getupdate() {
        return "UPDATE status_pedido SET pedido_id=?, progresso=? WHERE id=?";
    }
    
}
