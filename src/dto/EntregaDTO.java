package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Entrega;

public class EntregaDTO extends InterfaceDTO {
    public String idEntrega;
    public String tipoEntrega;
    public String statusPedidoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Entrega entrega = (Entrega) e;
        idEntrega = String.valueOf(entrega.getId());
        tipoEntrega = entrega.getTipoEntrega();
        statusPedidoId = String.valueOf(entrega.getStatusPedidoId());
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Entrega entrega = new Entrega();
        entrega.setId(Integer.parseInt(idEntrega));
        entrega.setTipoEntrega(tipoEntrega);
        entrega.setStatusPedidoId(Integer.parseInt(statusPedidoId));
        return entrega;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Tipo de Entrega", "Status do Pedido"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idEntrega, tipoEntrega, statusPedidoId};
    }
}
