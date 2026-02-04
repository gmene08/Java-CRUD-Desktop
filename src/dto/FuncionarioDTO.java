package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Funcionario;

public class FuncionarioDTO extends InterfaceDTO {
    public String idFuncionario;
    public String nome;
    public String cpf;
    public String rg;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Funcionario f = (Funcionario) e;
        idFuncionario = String.valueOf(f.getId());
        nome = f.getNome();
        cpf = f.getCpf();
        rg = f.getRg();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Funcionario f = new Funcionario();
        f.setId(Integer.parseInt(idFuncionario));
        f.setNome(nome);
        f.setCpf(cpf);
        f.setRg(rg);
        return f;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome", "CPF", "RG"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{idFuncionario, nome, cpf, rg};
    }
}
