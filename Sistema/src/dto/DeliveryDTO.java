package dto;

import model.Delivery;

public class DeliveryDTO {
    public String idDelivery;
    public String chaveEntrega;
    public String numero;
    public String complemento;

    public Delivery builder() {
        Delivery d = new Delivery();
        d.setId(idDelivery == null ? 0 : Integer.parseInt(idDelivery));
        d.setChaveEntrega(chaveEntrega == null ? 0 : Integer.parseInt(chaveEntrega));
        d.setNumero(numero);
        d.setComplemento(complemento);
        return d;
    }
}
