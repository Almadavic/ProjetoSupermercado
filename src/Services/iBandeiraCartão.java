package Services;

import Erro.Personalizado;

public interface iBandeiraCart�o {
 String verificarBandeira() throws Personalizado;
 
 
 default String senha(int senha) throws Personalizado {
	 if (senha!=123) {
		 throw new Personalizado("Senha Incorreta");
	 }
return "Senha v�lida";
 }
}
