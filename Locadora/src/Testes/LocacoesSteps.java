package Testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Item;
import Locavel.Locacao;
import RecursosHumanos.Cliente;

public class LocacoesSteps {
	
	
	private Item item;
	private Cliente cliente;
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	private Locacao locacao;
	

	@Given ("um item existente com o código $codigoBarras, um cliente com o cpf $cliente na data $data")
	public void localizaItem(String codigoBarras, String cpf, String data) throws RegistroInexistente, ParseException{
		item = Run.Main.bancoItem.Consulta(codigoBarras);
		cliente = Run.Main.bancoCliente.Consulta(cpf);
		Date dataLocacao = formatDate.parse(data);
		locacao = new Locacao(cliente,item,dataLocacao);
	}
	
	@When ("registramos a locacao")
	public void registrarLocacao() throws RegistroJaExiste{
		Run.Main.bancoLocacao.Insere(locacao);
	}
	
	@Then ("o Sistema exibe da locação")
	public void exibirInformacoesLocacao() throws RegistroInexistente{
		System.out.println(Run.Main.bancoLocacao.Consulta(locacao.getIndice()));
	}
	

}
