package Locavel;

import Banco.Tabelavel;

public class ItemEstoque implements Tabelavel {

	private int indice;
	private String codigo;
	private Filme filme;
	private Midia midia;
	private int quantidade;
	
	private String geraCodigo ( Filme filme, Midia midia ) {
		return filme.retornaValorChave() + " - " + midia.retornaValorChave();
	}
	
	public ItemEstoque( Filme filme, Midia midia) {
		
		this.indice = -1;
		this.filme = filme;
		this.midia = midia;
		this.quantidade = 1;
		this.codigo = geraCodigo(filme, midia);
		
	}
	
	public void incrementeQuantidade() {
		this.quantidade ++;
	}

	public boolean comparaCampoChave(String chave) {
		if ( this.codigo.equals(chave) ) {
			return true;
		}
		else {
			return false;
		}
	}

	public String retornaValorChave() {
		return this.codigo;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return this.indice;
	}

	public Filme getFilme() {
		return filme;
	}

	public Midia getMidia() {
		return midia;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
}
