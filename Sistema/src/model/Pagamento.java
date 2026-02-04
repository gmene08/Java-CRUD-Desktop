package model;
public class Pagamento {
    private int id;
    private int metPagamentoId;
    private int cupomId;
    private int pedidoId;

    private Pedido pedido;
    private Cupom cupom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMetPagamentoId() {
        return metPagamentoId;
    }

    public void setMetPagamentoId(int metPagamentoId) {
        this.metPagamentoId = metPagamentoId;
    }

    public int getCupomId() {
        return cupomId;
    }

    public void setCupomId(int cupomId) {
        this.cupomId = cupomId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }
    
    
}
