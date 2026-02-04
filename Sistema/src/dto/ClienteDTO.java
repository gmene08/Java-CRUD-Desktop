package dto;

import model.Cliente;
import model.Telefone;

public class ClienteDTO extends InterfaceDTO{
    public String idCliente;
    public String nomeCliente;
    public String telefoneCliente;
    
    public Cliente builder(){
        Cliente c = new Cliente();
        
        c.setId(idCliente == null ? 0 : Integer.valueOf(idCliente));
        c.setNome(nomeCliente);
        
        Telefone telefone = new Telefone();
        telefone.setId(telefoneCliente == null ? 0 : Integer.valueOf(telefoneCliente));
        c.setTelefone(telefone);
        
        return c;
    }
}
