package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Reembolso;

public class ReembolsoDTO extends InterfaceDTO {
    public String id;
    public String pedidoId;
    public String motivo;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Reembolso reembolso = (Reembolso) e;
        id = String.valueOf(reembolso.getId());
        pedidoId = String.valueOf(reembolso.getPedidoId());
        motivo = reembolso.getMotivo();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Reembolso reembolso = new Reembolso();
        reembolso.setId(Integer.parseInt(id));
        reembolso.setPedidoId(Integer.parseInt(pedidoId));
        reembolso.setMotivo(motivo);
        return reembolso;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Pedido ID", "Motivo"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, pedidoId, motivo};
    }
}
