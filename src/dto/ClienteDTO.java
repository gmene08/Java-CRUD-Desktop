package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Cliente;
import model.Telefone;

public class ClienteDTO extends InterfaceDTO {
    public String nomeCliente;
    public String telefoneCliente;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Cliente c = (Cliente) e;
        nomeCliente = c.getNome();
        telefoneCliente = (c.getTelefone() != null) ? c.getTelefone().getNumero() : null;
        id = String.valueOf(c.getId());  
        return this;
    }

    @Override
    public Entidade buildEntidade() {
    if (telefoneCliente != null && !telefoneCliente.isEmpty()) {
        Telefone telefone = new Telefone();  
        telefone.setNumero(telefoneCliente); 
        Cliente c = new Cliente();
        c.setNome(nomeCliente);  
        c.setTelefone(telefone);  

        return c;
    }
    return null;  
}

    @Override
    public String[] cabecalhoTable() {
        return new String[] { "ID", "Nome", "Telefone" };
    }

    @Override
    public Object[] dadosTable() {
        return new Object[] { id, nomeCliente, telefoneCliente };
    }
}
