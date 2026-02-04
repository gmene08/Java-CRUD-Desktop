package dto;

import model.Bairro;

public class BairroDTO extends InterfaceDTO{
    public String nomeBairro;
    public String idBairro;
    
    public Bairro builder(){
        Bairro b = new Bairro();
        b.setId(idBairro==null?0:Integer.valueOf(idBairro));
        b.setNome(nomeBairro);
        return b;
    }
}
