package Locavel;

import Banco.Tabelavel;

public abstract class Produto implements Tabelavel {

	private int indice;
	private String nome;
	private Double preco;
	
	public Produto(String nome,Double preco){
		this.indice = -1;
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Double getPreco() {
		return preco;
	}

	public boolean comparaCampoChave(String chave) {
		if ( this.nome.equals(chave) ) {
			return true;
		}
		else {
			return false;
		}
	}

	public String retornaValorChave() {
		return this.nome;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return this.indice;
	}
	
	
}
