package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Telefone;

public class TelefoneDTO extends InterfaceDTO {
    public String id;
    public String dd;
    public String numero;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Telefone telefoneEntity = (Telefone) e;
        id = String.valueOf(telefoneEntity.getId());
        dd = String.valueOf(telefoneEntity.getDd());
        numero = telefoneEntity.getNumero();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Telefone telefoneEntity = new Telefone();
        telefoneEntity.setId(Integer.parseInt(id));
        telefoneEntity.setDd(Integer.parseInt(dd));
        telefoneEntity.setNumero(numero);
        return telefoneEntity;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "DDD", "Número"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, dd, numero};
    }
}
