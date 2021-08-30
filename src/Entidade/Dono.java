package Entidade;

import Erro.Personalizado;

public class Dono {
private String Login="";
private String senha="";




public Dono(String login, String senha) throws Personalizado {
	if(!login.equals("teste") || !login.equals("teste")) {
		throw new Personalizado("Login ou/e senha inválida(o)");
	}
	Login = login;
	this.senha = senha;
}




public String getLogin() {
	return Login;
}
public void setLogin(String login) {
	Login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}






}
