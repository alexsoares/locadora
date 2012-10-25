package Testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Filme;
import Locavel.Genero;

public class CadastroFilmeSteps {

	private Filme filme;
	private Genero genero;
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Given ("Genero $nome com a descricao: $descricao")
	public void criarGenero(String nome, String descricao){
		genero = new Genero(nome,descricao);
	}
	
	@Given ("um novo filme com nome: $nome, custando $preco, lançando em $data com a faixa etária de $faixaEtaria anos, com a sinopse: ($sinopse) pertencente ao gênero $genero")
	public void cadastrarFilme(String nome, String preco, String data, int faixaEtaria, String sinopse, String genero) throws RegistroInexistente, ParseException{
		
		double dpreco = Double.parseDouble(preco);
		Date dataLancamento = formatDate.parse(data);
		this.filme = new Filme(nome, dpreco,dataLancamento, faixaEtaria,sinopse,genero);
		
	}
	
	@Given ("o Filme: $nomeFilme")
	public void localizarFilmeCadastrado(String nomeFilme) throws RegistroInexistente{
		this.filme = Run.Main.bancoFilme.Consulta(nomeFilme);
	}
	
	
	@When ("o cadastramos no Sistema")
	public void cadastrarFilmeSistema() throws RegistroJaExiste{
		Run.Main.bancoFilme.Insere(filme);
	}
	
	@When ("o inseremos no Sistema")
	public void inserirGenero() throws RegistroJaExiste{
		Run.Main.bancoGenero.Insere(genero);
	}
	
	@When ("atualizamos a sinopse para: $sinopse")
	public void atualizaSinopse(String sinopse) throws RegistroInexistente, RegistroJaExiste{
		this.filme.setSinopse(sinopse);
		Run.Main.bancoFilme.Altera(filme);
	}
	
	@When ("o removemos")
	public void removeFilme() throws RegistroInexistente{
		Run.Main.bancoFilme.Exclui(this.filme.getNome());
	}
	
	@Then ("o Sistema exibe as informações do Gênero adicionado.")
	public void exibeGenero() throws RegistroInexistente{
		System.out.println(Run.Main.bancoGenero.Consulta(genero.getNome()));
	}
	
	@Then ("o Sistema exibe as informações do Filme")
	public void exibirFilme() throws RegistroInexistente{
		System.out.println(Run.Main.bancoFilme.Consulta(filme.getNome()));
	}
	
	@Then ("podemos visualizar a nova sinopse nas informações do filme")
	public void exibirSinopseFilme() throws RegistroInexistente{
		System.out.println(Run.Main.bancoFilme.Consulta(filme.getNome()).getSinopse());
	}
	
	@Then ("o mesmo não aparecerá na lista de filmes cadastrados")
	public void exibirFilmesCadastrados(){
		LinkedList lista = Run.Main.bancoFilme.RetornaLinkedList();
		Iterator iterator = lista.iterator();
		while (iterator.hasNext()){
			Object f = iterator.next();
			System.out.println(f.toString());
			
		}
	}
	
}
