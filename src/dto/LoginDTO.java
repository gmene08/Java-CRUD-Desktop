package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Login;

public class LoginDTO extends InterfaceDTO {
    public String id;
    public String senha;
    public String login_funcionario;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Login login = (Login) e;
        id = String.valueOf(login.getId());
        senha = login.getSenha();
        login_funcionario = login.getLogin_funcionario();
        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Login login = new Login();
        login.setId(Integer.parseInt(id));
        login.setSenha(senha);
        login.setLogin_funcionario(login_funcionario);
        return login;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Senha", "Login Funcionario"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, senha, login_funcionario};
    }
}
