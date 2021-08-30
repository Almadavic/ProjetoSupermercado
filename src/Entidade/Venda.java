package Entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Erro.Personalizado;

public class Venda {
private Integer numero=0;
private Date now = new Date();
private Integer parcelas=0;
private Double descontos=0.0;
private List<ItemVenda> list = new ArrayList<>();
public Venda(Integer numero, Integer parcelas) {
	this.numero = numero;
	this.parcelas = parcelas;
}

public void adicionarItem(ItemVenda item) {
	list.add(item);
}

public void removerItem(ItemVenda item) {
	list.remove(item);
}


public double total() {
	double soma=0;
	for (ItemVenda item : list) {
		soma = soma+item.subTotal();
	}
	return soma;
}


List<String> dates = new ArrayList<>();
private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
public void validaçãoTempo() {
	Calendar cal = Calendar.getInstance();
	for (int i=1;i<parcelas;i++) {
	cal.setTime(now);
	cal.add(Calendar.MONTH, i);
Date data = cal.getTime();
String dataFormatada = sdf.format(data);
dates.add(dataFormatada);
	
	}
}

public void validação() throws Personalizado {
	if(getNumero()==null) {
		throw new Personalizado("Nenhum item adicionado");
	}
}


public Integer getNumero() {
	return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}
public Integer getParcelas() {
	return parcelas;
}
public void setParcelas(Integer parcelas) {
	this.parcelas = parcelas;
}
public Double getDescontos() {
	return descontos;
}
public void setDescontos(Double descontos) {
	this.descontos = descontos;
}
public List<ItemVenda> getList() {
	return list;
}


}
