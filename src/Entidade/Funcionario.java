package Entidade;

import Erro.Personalizado;

public abstract class Funcionario {
private String nome="";
private Double salario=0.0;
private Double descontos=0.0;

public Funcionario() {
	
}

public Funcionario(String nome, Double salario, Double descontos) {
	this.nome = nome;
	this.salario = salario;
	this.descontos = descontos;
}

public abstract void validação() throws Personalizado;

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Double getSalario() {
	return salario;
}

public void setSalario(Double salario) {
	this.salario = salario;
}

public Double getDescontos() {
	return descontos;
}

public void setDescontos(Double descontos) {
	this.descontos = descontos;
}


public abstract double calcularSalario() throws Personalizado;

public abstract String formated() throws Personalizado;

}
