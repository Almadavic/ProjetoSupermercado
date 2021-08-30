package Entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Enumerados.Pago;
import Enumerados.StatusVenda;
import Enumerados.TipoPagamento;
import Erro.Personalizado;

public class Venda {
private Integer numero=0;
private Date now = new Date();
private Integer parcelas=0;
private final Double descontos=20.0;
private List<ItemVenda> list = new ArrayList<>();
private Pago pago=null;
private StatusVenda status=null;
private TipoPagamento tipoPagamento=null;
private Cliente cliente=null;
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


public String recibo() {
	StringBuilder bd = new StringBuilder();
	setStatus(StatusVenda.INICIANDO);
	setStatus(StatusVenda.PROCESSANDO);
	 bd.append("======================\n");
	    bd.append("DADOS DA VENDA : \n");
	    bd.append("======================\n");
	    if (cliente!=null) {
	    	bd.append(cliente+"\n");
	    } else {
	    	bd.append("Cliente : não cadastrado\n");
	    }
	    bd.append("Número do pedido : "+getNumero()+"\n");
	     bd.append("Data da compra : "+sdf.format(now)+"\n");
	     setStatus(StatusVenda.IMPRIMINDO);
	     bd.append("Status : "+getStatus()+"\n");
	     bd.append("Forma de pagamento : "+getTipoPagamento()+"\n");
	     bd.append("ITENS DA VENDA \n");
	     bd.append("====================== \n");
	     Collections.sort(list);
	     for (ItemVenda item : list) {
	    	 int i =1;
	    	item.setNumero(i);
	    	bd.append(item+"\n");
	     }
	     if (getTipoPagamento()==TipoPagamento.CARTÃO) {
	    	 validaçãoTempo();
	    	 for(int i =0;i<dates.size();i++) {
	    		 bd.append((i+1)+" parcela : "+dates.get(i) + " valor : R$"+String.format("%.2f",pagamento()+"\n"));
	    	 }
	    	 if(cliente!=null && total()>100) {
	    		 bd.append("Desconto : -"+descontos()+"\n");
	    	 }
	    	 bd.append("Total : "+descontos()+"\n");
	    	 bd.append("Situação : "+getPago()+"\n");
	    	    bd.append("======================\n");
	    	    setStatus(StatusVenda.valueOf("FINALIZANDO"));
	     }
	return bd.toString();
}
public double descontos() {
	if(cliente!=null && total()>100) {
		return total()-20;
	}
	else {
		return total();
	}
}

public double pagamento() {

	if(getTipoPagamento()==TipoPagamento.CARTÃO) {
		double total=total()/parcelas;
		return total;
		} else {
		return	total();
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

public List<ItemVenda> getList() {
	return list;
}

public TipoPagamento getTipoPagamento() {
	return tipoPagamento;
}

public void setTipoPagamento(TipoPagamento tipoPagamento) {
	this.tipoPagamento = tipoPagamento;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}




public Pago getPago() {
	return pago;
}

public void setPago(Pago pago) {
	this.pago = pago;
}

private StatusVenda getStatus() {
	return status;
}

private void setStatus(StatusVenda status) {
	this.status = status;
}

public List<String> getDates() {
	return dates;
}




}
