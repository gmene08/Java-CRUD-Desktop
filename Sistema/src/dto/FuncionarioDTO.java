package dto;

import model.Funcionario;

public class FuncionarioDTO extends InterfaceDTO{
    public String idFuncionario;
    public String nome;
    public String cpf;
    public String rg;

    public Funcionario builder() {
        Funcionario f = new Funcionario();
        f.setId(idFuncionario == null ? 0 : Integer.parseInt(idFuncionario));
        f.setNome(nome);
        f.setCpf(cpf);
        f.setRg(rg);
        return f;
    }
}
