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
import Locavel.Item;
import Locavel.Midia;

public class CadastroItensSteps {
	
	private Item item;
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	@Given ("um item que possui o código de barras $codigoBarra, associado ao filme $filme, na mídia $midia, realizado na data $data")
	public void cadastrarItem(String codigo_barra,String nomefilme, String nomeMidia, String data) throws RegistroInexistente, ParseException{
		Filme filme = Run.Main.bancoFilme.Consulta(nomefilme);
		Midia midia = Run.Main.bancoMidia.Consulta(nomeMidia);
		Date data_aquisicao = formatDate.parse(data);
		item = new Item(codigo_barra, filme, midia,data_aquisicao);
	}
	
	@Given ("um item cadastrado com o código de barras igual a $codigoBarra")
	public void consultarItem(String codigoBarra) throws RegistroInexistente{
		item = Run.Main.bancoItem.Consulta(codigoBarra);
	}
	
	@When ("o cadastramos no sistema") 
	public void cadastrarItemSistema() throws RegistroJaExiste{
		Run.Main.bancoItem.Insere(item);
	}
	
	@When ("alteramos o filme do item para $nomeFilme")
	public void alterarItem(String nomeFilme) throws RegistroInexistente, RegistroJaExiste{
		Filme filme = Run.Main.bancoFilme.Consulta(nomeFilme);
		item.setFilme(filme);
		Run.Main.bancoItem.Altera(item);
	}
	
	@When ("o removemos do Sistema")
	public void removerItem() throws RegistroInexistente{
		Run.Main.bancoItem.Exclui(item.getCodigo_barra());
	}
	
	@Then ("o Sistema retorna os dados do item $codigoBarra")
	public void exibeDados(String codigoBarra) throws RegistroInexistente{
		System.out.println(Run.Main.bancoItem.Consulta(codigoBarra));
	}
	
	@Then ("o Sistema retorna todos os itens cadastrados")
	public void exibirTodosItens(){
		LinkedList<Item> lista = Run.Main.bancoItem.RetornaLinkedList();
		Iterator<Item> iterator = lista.iterator();
		
		while (iterator.hasNext()){
			Item itemTemp = iterator.next();
			System.out.println(itemTemp.toString());
		}
	}
}
