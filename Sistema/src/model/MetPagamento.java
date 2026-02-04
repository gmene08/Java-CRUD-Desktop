package model;
public class MetPagamento {
    private int id;
    private Integer dinheiroId;
    private Integer cartaoId;

    private Pagamento pagamento;
    private Cartao cartao;
    private Dinheiro dinheiro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDinheiroId() {
        return dinheiroId;
    }

    public void setDinheiroId(Integer dinheiroId) {
        this.dinheiroId = dinheiroId;
    }

    public Integer getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Integer cartaoId) {
        this.cartaoId = cartaoId;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    
            
}