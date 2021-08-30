package Services;

public abstract  class abstractService implements iBandeiraCartão {
private Integer setor=0;

public abstractService(Integer setor) {
	this.setor = setor;
}

public Integer getSetor() {
	return setor;
}

public void setSetor(Integer setor) {
	this.setor = setor;
}




	

}
