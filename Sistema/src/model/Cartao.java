package model;
public class Cartao {
    private int id;
    private String numCartao;
    private String cvv;
    private int tipo; // 1: crédito, 2: débito

    private MetPagamento metPagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public MetPagamento getMetPagamento() {
        return metPagamento;
    }

    public void setMetPagamento(MetPagamento metPagamento) {
        this.metPagamento = metPagamento;
    }
    
    
}
