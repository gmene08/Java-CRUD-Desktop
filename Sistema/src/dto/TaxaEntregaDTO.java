package dto;

import model.TaxaEntrega;

public class TaxaEntregaDTO {
    public String id;
    public String enderecoId;
    public String taxaEntrega;

    public TaxaEntrega builder() {
        TaxaEntrega te = new TaxaEntrega();
        te.setId(id == null ? 0 : Integer.parseInt(id));
        te.setEnderecoId(enderecoId == null ? 0 : Integer.parseInt(enderecoId));
        te.setTaxaEntrega(taxaEntrega == null ? 0 : Double.parseDouble(taxaEntrega));
        return te;
    }
}
