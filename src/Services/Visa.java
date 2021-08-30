package Services;
import Erro.Personalizado;
import Services.abstractService;
public class Visa extends abstractService {

	public Visa(Integer setor) {
		super(setor);
	}

	@Override
	public String verificarBandeira() throws Personalizado {
		if (getSetor()!=4) {
			throw new Personalizado("**BANDEIRA N�O CONFERE PARA MASTERCARD");
		}
		else {
			return "*BANDEIRA N�O CONFERE";
		}
	}
	
	
	

}
