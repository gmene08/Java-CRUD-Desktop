package dto;

import model.Login;

public class LoginDTO {
    public String id;
    public String senha;
    public String login_funcionario;

    public Login builder() {
        Login l = new Login();
        l.setId(id == null ? 0 : Integer.parseInt(id));
        l.setSenha(senha);
        l.setLogin_funcionario(login_funcionario);
        return l;
    }
}
