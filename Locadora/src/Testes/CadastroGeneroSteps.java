package Testes;

import java.util.Iterator;
import java.util.LinkedList;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Genero;

public class CadastroGeneroSteps {

	private Genero genero;
	
	@Given ("o gênero $genero com a descrição: $descricao (ainda não cadastrado)")
	public void cadastrarGenero(String nome,String descricao){
		genero = new Genero(nome,descricao);
	}
	
	@Given ("um genêro cadastrado, $genero")
	public void buscarGeneroCadastrado(String nomeGenero) throws RegistroInexistente{
		this.genero = Run.Main.bancoGenero.Consulta(nomeGenero);
	}
	
	@When ("o cadastro no Sistema")
	public void cadastrarGeneroSistema() throws RegistroJaExiste{
		Run.Main.bancoGenero.Insere(genero);
	}
	
	@When ("atualizo a descrição para $novaDescricao")
	public void atualizaDescricaoGenero(String novaDescricao) throws RegistroInexistente, RegistroJaExiste{
		this.genero.setDescricao(novaDescricao);
		Run.Main.bancoGenero.Altera(genero);
	}
	
	@When ("o mesmo é removido")
	public void removerGenero() throws RegistroInexistente{
		Run.Main.bancoGenero.Exclui(this.genero.getNome());
	}
	
	@Then ("o Sistema exibe as informações do gênero")
	public void exibeGenero() throws RegistroInexistente{
		System.out.println(Run.Main.bancoGenero.Consulta(genero.getNome()));
	}
	
	@Then ("o Sistema exibe todos os gêneros cadastrados")
	public void exibeTodosOsGeneros(){
		LinkedList<Genero> lista = Run.Main.bancoGenero.RetornaLinkedList();
		Iterator<Genero> iterator = lista.iterator();
		
		while(iterator.hasNext()){
			Genero gen = iterator.next();
			System.out.println(gen.toString());
		}
		
	}
	
}
