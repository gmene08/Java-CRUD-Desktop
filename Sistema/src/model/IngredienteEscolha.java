package model;
public class IngredienteEscolha {
    private int id;
    private Integer ingredienteEscolhaId;
    private Integer ingredienteRemoverId;
    
    private Carrinho carrinho;
    private IngredienteRemover ingredienteRemover;
    private IngredienteAdicional ingredienteAdicional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIngredienteEscolhaId() {
        return ingredienteEscolhaId;
    }

    public void setIngredienteEscolhaId(Integer ingredienteEscolhaId) {
        this.ingredienteEscolhaId = ingredienteEscolhaId;
    }

    public Integer getIngredienteRemoverId() {
        return ingredienteRemoverId;
    }

    public void setIngredienteRemoverId(Integer ingredienteRemoverId) {
        this.ingredienteRemoverId = ingredienteRemoverId;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public IngredienteRemover getIngredienteRemover() {
        return ingredienteRemover;
    }

    public void setIngredienteRemover(IngredienteRemover ingredienteRemover) {
        this.ingredienteRemover = ingredienteRemover;
    }

    public IngredienteAdicional getIngredienteAdicional() {
        return ingredienteAdicional;
    }

    public void setIngredienteAdicional(IngredienteAdicional ingredienteAdicional) {
        this.ingredienteAdicional = ingredienteAdicional;
    }
    
    
    
}
