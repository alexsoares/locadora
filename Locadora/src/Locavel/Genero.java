package Locavel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Genero {

	private String nome;
	private String descricao;
	List<Filme> filmes = new LinkedList<Filme>();
	
	
	public Genero(String nome, String descricao){
		this.nome = nome;
		this.descricao = descricao;

	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void addFilme (Filme filme){
		this.filmes.add(filme);
	}
	public void removeFilme(Filme filme){
		this.filmes.remove(filme);
	}
	
	public List<String> listFilme(){
		
		List<String> listaDeFilmes = new ArrayList<String>();
		
		ListIterator<Filme> iterator = filmes.listIterator();
		
		while (iterator.hasNext()){
			Filme tempFilme = iterator.next();
			listaDeFilmes.add(tempFilme.getNome());
		}
		
		return listaDeFilmes;
		
	}
	
	
}
