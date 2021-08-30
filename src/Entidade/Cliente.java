package Entidade;

import java.util.Objects;

public class Cliente {
private String nome="";
private String email="";
public Cliente(String nome, String email) {
	this.nome = nome;
	this.email = email;
}



public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}







@Override
public int hashCode() {
	return Objects.hash(email);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	return Objects.equals(email, other.email);
}



@Override
public String toString() {
	return "Nome : "+nome+" ,Email : "+email;
}


}
