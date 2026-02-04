package dto;

import model.Bairro;
import model.Delivery;
import model.Endereco;

public class EnderecoDTO {
    public String idEndereco;
    public String rua;
    public String cep;
    public String distancia;
    public String idDelivery;
    public String idBairro;

    public Endereco builder() {
        Endereco e = new Endereco();
        e.setId(idEndereco == null ? 0 : Integer.parseInt(idEndereco));
        e.setRua(rua);
        e.setCep(cep);
        e.setDistancia(distancia == null ? 0 : Double.parseDouble(distancia));

        Delivery delivery = new Delivery();
        delivery.setId(idDelivery == null ? 0 : Integer.parseInt(idDelivery));
        e.setDelivery(delivery);

        Bairro bairro = new Bairro();
        bairro.setId(idBairro == null ? 0 : Integer.parseInt(idBairro));
        e.setBairro(bairro);

        return e;
    }
}
