package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Bairro;

public class BairroDTO extends InterfaceDTO{
    public String nomeBairro;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Bairro b = (Bairro) e;
        nomeBairro = b.getNome();
        id = b.getId() + "";
        return this;
    }

    @Override
    public Entidade buildEntidade() {
       Bairro b = new Bairro();
       b.setId(id);
       b.setNome(nomeBairro);
       return b;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"Nome"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{nomeBairro};
    }
    
}
