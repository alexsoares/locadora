package Testes;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Midia;

public class CadastroMidiasSteps {
	
	private Midia midia;

	@Given ("uma nova mídia, $midia com a descricao: $descricao")
	public void cadastrarMidia(String nome,String descricao){
		midia = new Midia(nome,descricao);
	}
	
	@When ("a cadastramos no Sistema")
	public void cadastrarMidiaSistema() throws RegistroJaExiste{
		Run.Main.bancoMidia.Insere(midia);
	}
	
	@Then ("o Sistema exibe as informações da mídia")
	public void exibirInformacoesMidia() throws RegistroInexistente{
		System.out.println(Run.Main.bancoMidia.Consulta(midia.getCodigo()));
	}

}
