package Testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import RecursosHumanos.Cliente;

public class CadastroClienteSteps {

	private Cliente novoCliente;
	

	@Given("um novo cliente com nome: $nome, cpf: $cpf, nascido no dia $dataNascimento")
	public void cadastrarNovoCliente(String nome, String cpf, String dataNascimento) throws ParseException{
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		this.novoCliente = new Cliente(nome,cpf,formatDate.parse(dataNascimento));
	}
	
	@When("cadastramos o cliente no Sistema")
	public void cadastro() throws RegistroJaExiste{
		Run.Main.bancoCliente.Insere(novoCliente);
	}
	
	@Then ("o Sistema exibe as informações do cliente")
	public void checkCadastro() throws RegistroInexistente{
		System.out.println(Run.Main.bancoCliente.Consulta(this.novoCliente.getCpf()).toString());
	}
	
	@When ("o consultamos pelo CPF")
	public void consultarCliente() throws RegistroInexistente{
		Run.Main.bancoCliente. Consulta(this.novoCliente.getCpf()).toString();
	}
	
	@Given ("um cliente já cadastrado")
	public void clienteCadastrado(){
		System.out.println(this.novoCliente.getNome());
	}
	
	@When ("alteramos o email para $email")
	public void alterarEmail(String emailNovo) throws RegistroInexistente, RegistroJaExiste{
		String emailAntigo = this.novoCliente.getEmail();
		this.novoCliente.setEmail(emailNovo);
		Run.Main.bancoCliente.Altera(this.novoCliente);
	}
	
	@Then ("o Sistema exibe o e-mail alterado")
	public void exiberEmail() throws RegistroInexistente{
		System.out.println("E-mail: "  + Run.Main.bancoCliente.Consulta(this.novoCliente.getCpf()).getEmail());
	}
	
	@When ("o removemos")
	public void removerCliente() throws RegistroInexistente{
		Run.Main.bancoCliente.Exclui(this.novoCliente.getCpf());
	}
	
	@Then ("o Sistema exibe um diálogo informando que o cliente não está mais cadastrado")
	public void clienteRemovido(){
		System.out.println("Cliente removido.");
	}
	
}
