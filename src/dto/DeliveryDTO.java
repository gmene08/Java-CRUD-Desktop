package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Delivery;

public class DeliveryDTO extends InterfaceDTO {
    public String idDelivery;
    public String chaveEntrega;
    public String numero;
    public String complemento;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Delivery d = (Delivery) e;
        idDelivery = d.getId() + "";
        chaveEntrega = String.valueOf(d.getChaveEntrega());
        numero = d.getNumero();
        complemento = d.getComplemento();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Delivery d = new Delivery();
        d.setId(Integer.parseInt(idDelivery));
        d.setChaveEntrega(Integer.parseInt(chaveEntrega));
        d.setNumero(numero);
        d.setComplemento(complemento);
        return d;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Chave de Entrega", "Número", "Complemento"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idDelivery, chaveEntrega, numero, complemento};
    }
}
