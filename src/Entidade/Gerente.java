package Entidade;

import Erro.Personalizado;

public class Gerente extends Funcionario {
private Double comiss�o=0.0;

public Gerente() {
	super();
}




	
	public Gerente(String nome, Double salario, Double descontos, Double comiss�o) {
	super(nome, salario, descontos);
	this.comiss�o = comiss�o;
}





	@Override
	public void valida��o() throws Personalizado {
		if (getNome()==null || getSalario()==null || getDescontos()==null || comiss�o==null) {
			throw new Personalizado("N�o se deve haver valores nulos");
		}
		
	}

	@Override
	public double calcularSalario() throws Personalizado {
		valida��o();
		return (getSalario()+comiss�o)-getDescontos();
	}

	@Override
	public String formated() throws Personalizado {
		return "Nome : "+getNome()+" ,Salario base : "+getSalario()+" ,Sal�rio Final : "+calcularSalario();
	}

	public Double getComiss�o() {
		return comiss�o;
	}

	public void setComiss�o(Double comiss�o) {
		this.comiss�o = comiss�o;
	}
	
	
	

}
