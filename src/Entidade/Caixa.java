package Entidade;

import Erro.Personalizado;

public class Caixa extends Funcionario {

	private Integer caixa=0;
	
	
	
	
	public Caixa(String nome, Double salario, Double descontos, Integer caixa) {
		super(nome, salario, descontos);
		this.caixa = caixa;
	}
	

	@Override
	public void valida��o() throws Personalizado {
		if (getNome()==null || getSalario()==null || getDescontos()==null || caixa==null) {
			throw new Personalizado("N�o se deve haver valores nulos");
		}
		
	}

	@Override
	public double calcularSalario() throws Personalizado {
	valida��o();
		return getSalario()-getDescontos();
	}

	@Override
	public String formated() throws Personalizado {
		return "Nome : "+getNome()+" ,Guiche : "+caixa+" ,Sal�rio Base : "+getSalario()+" , Sal�rio Final : "+calcularSalario();
	}


	public Integer getCaixa() {
		return caixa;
	}


	public void setCaixa(Integer caixa) {
		this.caixa = caixa;
	}
	
	
	

}
