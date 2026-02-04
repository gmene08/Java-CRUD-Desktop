package model;
public class Dinheiro {
    private int id;
    private double valorEntregue;
    
    private MetPagamento metPagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getValorEntregue() {
        return valorEntregue;
    }

    public void setValorEntregue(double valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    public MetPagamento getMetPagamento() {
        return metPagamento;
    }

    public void setMetPagamento(MetPagamento metPagamento) {
        this.metPagamento = metPagamento;
    }
    
    
}
