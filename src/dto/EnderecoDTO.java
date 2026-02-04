package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Bairro;
import model.Delivery;
import model.Endereco;

public class EnderecoDTO extends InterfaceDTO {
    public String idEndereco;
    public String rua;
    public String cep;
    public String distancia;
    public String idDelivery;
    public String idBairro;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Endereco endereco = (Endereco) e;
        idEndereco = String.valueOf(endereco.getId());
        rua = endereco.getRua();
        cep = endereco.getCep();
        distancia = String.valueOf(endereco.getDistancia());
        idDelivery = String.valueOf(endereco.getDelivery() != null ? endereco.getDelivery().getId() : null);
        idBairro = String.valueOf(endereco.getBairro() != null ? endereco.getBairro().getId() : null);
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Endereco endereco = new Endereco();
        endereco.setId(Integer.parseInt(idEndereco));
        endereco.setRua(rua);
        endereco.setCep(cep);
        endereco.setDistancia(Double.parseDouble(distancia));

        if (idDelivery != null && !idDelivery.isEmpty()) {
            endereco.setDelivery(new Delivery(Integer.parseInt(idDelivery)));
        }

        if (idBairro != null && !idBairro.isEmpty()) {
            endereco.setBairro(new Bairro(Integer.parseInt(idBairro)));
        }

        return endereco;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Rua", "CEP", "Distância", "Delivery ID", "Bairro ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idEndereco, rua, cep, distancia, idDelivery, idBairro};
    }
}
