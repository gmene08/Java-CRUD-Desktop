package interfaces;

import java.util.List;

public abstract class InterfaceController {
    protected InterfaceDTO dto;
     
    public abstract Boolean salvar();
    public abstract Boolean editar();
    public abstract List<InterfaceDTO> listar();
    public abstract Boolean remover(Integer id) throws Exception;
    public Object[] preencheLinha(){
        return dto.dadosTable();
    }
    public String[] cabecalho(){
        return dto.cabecalhoTable();
    }

    public void setDto(InterfaceDTO dto) {
        this.dto = dto;
    }

    public InterfaceDTO getDto() {
        return dto;
    }
            
}
