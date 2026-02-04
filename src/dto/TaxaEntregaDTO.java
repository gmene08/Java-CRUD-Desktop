package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.TaxaEntrega;

public class TaxaEntregaDTO extends InterfaceDTO {
    public String id;
    public String enderecoId;
    public String taxaEntrega;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        TaxaEntrega taxaEntregaEntity = (TaxaEntrega) e;
        id = String.valueOf(taxaEntregaEntity.getId());
        enderecoId = String.valueOf(taxaEntregaEntity.getEnderecoId());
        taxaEntrega = String.valueOf(taxaEntregaEntity.getTaxaEntrega());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        TaxaEntrega taxaEntregaEntity = new TaxaEntrega();
        taxaEntregaEntity.setId(Integer.parseInt(id));
        taxaEntregaEntity.setEnderecoId(Integer.parseInt(enderecoId));
        taxaEntregaEntity.setTaxaEntrega(Double.parseDouble(taxaEntrega));
        return taxaEntregaEntity;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Endereço ID", "Taxa de Entrega"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, enderecoId, taxaEntrega};
    }
}
