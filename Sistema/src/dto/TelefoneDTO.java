package dto;

import model.Telefone;

public class TelefoneDTO {
    public String id;
    public String dd;
    public String numero;

    public Telefone builder() {
        Telefone t = new Telefone();
        t.setId(id == null ? 0 : Integer.parseInt(id));
        t.setDd(dd == null ? 0 : Integer.parseInt(dd));
        t.setNumero(numero == null ? 0 : Integer.parseInt(numero));
        return t;
    }
}
