package Services;

import Erro.Personalizado;

public interface iBandeiraCartão {
 String verificarBandeira() throws Personalizado;
 
 
 default String senha(int senha) throws Personalizado {
	 if (senha!=123) {
		 throw new Personalizado("Senha Incorreta");
	 }
return "Senha válida";
 }
}
