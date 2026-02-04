package model;
public class Delivery {
    private int id;
    private int chaveEntrega;
    private String numero;
    private String complemento;
    
    private Entrega entrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChaveEntrega() {
        return chaveEntrega;
    }

    public void setChaveEntrega(int chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
    
    

}
