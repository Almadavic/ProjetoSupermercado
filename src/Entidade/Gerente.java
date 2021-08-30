package Entidade;

import Erro.Personalizado;

public class Gerente extends Funcionario {
private Double comissão=0.0;

public Gerente() {
	super();
}




	
	public Gerente(String nome, Double salario, Double descontos, Double comissão) {
	super(nome, salario, descontos);
	this.comissão = comissão;
}





	@Override
	public void validação() throws Personalizado {
		if (getNome()==null || getSalario()==null || getDescontos()==null || comissão==null) {
			throw new Personalizado("Não se deve haver valores nulos");
		}
		
	}

	@Override
	public double calcularSalario() throws Personalizado {
		validação();
		return (getSalario()+comissão)-getDescontos();
	}

	@Override
	public String formated() throws Personalizado {
		return "Nome : "+getNome()+" ,Salario base : "+getSalario()+" ,Salário Final : "+calcularSalario();
	}

	public Double getComissão() {
		return comissão;
	}

	public void setComissão(Double comissão) {
		this.comissão = comissão;
	}
	
	
	

}
