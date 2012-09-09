package Visual;

import java.util.Date;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Item;
import Locavel.Locacao;
import RecursosHumanos.Cliente;

public class OperaLocacao {

	public void realizarLocacao ( Locacao locacao ) throws RegistroJaExiste {
		
		Cliente cliente = null;
		try {
			cliente = Run.Main.bancoCliente.Consulta(locacao.getCliente().getIndice());
		} catch (RegistroInexistente e1) {
			e1.printStackTrace();
		}
		cliente.setLocacaoEmAndamento(true);
		
		Item item = null;
		try {
			item = Run.Main.bancoItem.Consulta(locacao.getItem().getIndice());
		} catch (RegistroInexistente e) {
			e.printStackTrace();
		}
		item.locar();
		
		Run.Main.bancoLocacao.Insere(locacao);
		
	}
	
	public void realizaDevolucao (String codigoLocacao, Date dataDevolucao) throws RegistroInexistente {
		
		Locacao locacao = Run.Main.bancoLocacao.Consulta(codigoLocacao);
		locacao.devolucao(dataDevolucao);
		
		Cliente cliente = Run.Main.bancoCliente.Consulta(locacao.getCliente().getIndice());
		cliente.setLocacaoEmAndamento(false);
		
		Item item = Run.Main.bancoItem.Consulta(locacao.getItem().getIndice());
		item.devolver();
		
	}
	
}
