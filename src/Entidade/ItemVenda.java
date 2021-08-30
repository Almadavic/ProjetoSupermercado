package Entidade;

public class ItemVenda implements Comparable<ItemVenda> {
private Integer numero=0;
private String nome="";
private Double valorUnitario=0.0;
private Integer quantidade=0;




public ItemVenda(String nome, Double valorUnitario, Integer quantidade) {
	this.nome = nome;
	this.valorUnitario = valorUnitario;
	this.quantidade = quantidade;
}




public Integer getNumero() {
	return numero;
}




public void setNumero(Integer numero) {
	this.numero = numero;
}




public String getNome() {
	return nome;
}




public void setNome(String nome) {
	this.nome = nome;
}




public Double getValorUnitario() {
	return valorUnitario;
}




public void setValorUnitario(Double valorUnitario) {
	this.valorUnitario = valorUnitario;
}




public Integer getQuantidade() {
	return quantidade;
}




public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}


private Double subTotal;

public double subTotal() {
	this.subTotal=valorUnitario*quantidade;
	return this.subTotal;
}

@Override
public String toString() {
				return numero+" - "+nome+" R$"+valorUnitario+" x "+quantidade+" = R$"+subTotal();
			
}




public double getSubTotal() {
	return subTotal;
}




public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}




@Override
public int compareTo(ItemVenda other) {
		return subTotal.compareTo(other.subTotal);
}



}
